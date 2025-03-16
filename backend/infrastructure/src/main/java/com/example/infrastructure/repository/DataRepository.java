package com.example.infrastructure.repository;

import com.example.domain.Data;
import com.example.domain.DataStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<DataEntity, Long> {
    List<DataEntity> findByStatus(DataStatus status);
    List<DataEntity> findByContentContaining(String keyword);
}