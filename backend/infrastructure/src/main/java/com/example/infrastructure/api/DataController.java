package com.example.infrastructure.api;


import com.example.application.DataService;
import com.example.domain.Data;
import com.example.domain.DataStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

//    @GetMapping("/message")
//    public ResponseEntity<Message> getMessage() {
//        return ResponseEntity.ok(dataService.getMessage());
//    }

    // data

    @GetMapping
    public ResponseEntity<List<Data>> getAllData() {
        System.out.println("getAllData start");

        return ResponseEntity.ok(dataService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Data> getDataById(@PathVariable Long id) {
        System.out.println("getDataById start");
        Optional<Data> data = dataService.findById(id);
        return data.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Data> createData(@Valid @RequestBody Data newData) {
        System.out.println("createData start newData=" + newData.toString());

        // Assurer que l'ID est null pour la création
        newData.setId(null);

        // Définir le timestamp actuel
        if (newData.getTimestamp() == null) {
            newData.setTimestamp(java.time.LocalDateTime.now());
        }

        // Définir le statut par défaut si non spécifié
        if (newData.getStatus() == null) {
            newData.setStatus(DataStatus.PENDING);
        }

        Data savedData = dataService.save(newData);
        // Ajouter des logs pour vérifier les données sauvegardées
        System.out.println("createData saved Data: " + savedData);

        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Data> updateData(@PathVariable Long id, @Valid @RequestBody Data updatedData) {
        System.out.println("updateData start");
        return dataService.findById(id)
                .map(existingData -> {
                    existingData.setContent(updatedData.getContent());
                    existingData.setStatus(updatedData.getStatus());
                    return ResponseEntity.ok(dataService.save(existingData));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        System.out.println("deleteData start");
        return dataService.findById(id)
                .map(data -> {
                    dataService.delete(data);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Data>> getDataByStatus(@PathVariable DataStatus status) {
        System.out.println("getDataByStatus start");
        return ResponseEntity.ok(dataService.findByStatus(status));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Data>> searchData(@RequestParam String keyword) {
        System.out.println("searchData start");
        return ResponseEntity.ok(dataService.findByContentContaining(keyword));
    }







}
