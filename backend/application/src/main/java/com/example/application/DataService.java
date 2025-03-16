package com.example.application;

import com.example.domain.Data;
import com.example.domain.DataStatus;
import com.example.domain.port.IDataPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    private final IDataPort dataAdapter;

    public DataService(IDataPort dataAdapter) {
        this.dataAdapter = dataAdapter;
    }

    public Data getMessage() {
        return dataAdapter.getData();
    }

    public List<Data> findAll() { return dataAdapter.findAll(); }

    public Optional<Data> findById(Long id) { return dataAdapter.findById(id); }

    public Data save(Data newData) { return dataAdapter.save(newData); }

    public void delete(Data data) { dataAdapter.delete(data); }

    public List<Data> findByStatus(DataStatus status) { return dataAdapter.findByStatus(status); }

    public List<Data> findByContentContaining(String content) { return dataAdapter.findByContentContaining(content); }
}
