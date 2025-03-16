package com.example.infrastructure.repository;

import com.example.domain.Data;
import com.example.domain.DataStatus;
import com.example.domain.port.IDataPort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DataAdapter implements IDataPort {
    private final DataRepository repository;
    private final DataMapper mapper;

    public DataAdapter(DataRepository repository, DataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Data getData() {
        return repository.findAll().stream()
                .findFirst()
                .map(mapper::toData)
                .orElse(null);
    }

    @Override
    public List<Data> findAll() {
        return repository.findAll().stream()
                .map(mapper::toData)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Data> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toData);
    }

    @Override
    public Data save(Data newData) {
        DataEntity savedDataEntity = repository.saveAndFlush(mapper.toEntity(newData));
        return mapper.toData(savedDataEntity);
    }

    @Override
    public void delete(Data data) {
        repository.delete(mapper.toEntity(data));
    }

    @Override
    public List<Data> findByStatus(DataStatus status) {
        return repository.findByStatus(status).stream()
                .map(mapper::toData)
                .collect(Collectors.toList());
    }

    @Override
    public List<Data> findByContentContaining(String content) {
        return repository.findByContentContaining(content).stream()
                .map(mapper::toData)
                .collect(Collectors.toList());
    }
}
