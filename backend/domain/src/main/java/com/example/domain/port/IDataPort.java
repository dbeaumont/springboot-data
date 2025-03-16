package com.example.domain.port;

import com.example.domain.Data;
import com.example.domain.DataStatus;

import java.util.List;
import java.util.Optional;

public interface IDataPort {
    Data getData();

    List<Data> findAll();

    Optional<Data> findById(Long id);

    Data save(Data newData);

    void delete(Data data);

    List<Data> findByStatus(DataStatus status);

    List<Data> findByContentContaining(String content);
}
