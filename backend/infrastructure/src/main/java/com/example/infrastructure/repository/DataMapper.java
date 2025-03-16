package com.example.infrastructure.repository;

import com.example.domain.Data;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {
    public Data toData(DataEntity entity) {
        Data data = new Data();
        data.setId(entity.getId());
        data.setContent(entity.getContent());
        return data;
    }

    public DataEntity toEntity(Data data) {
        DataEntity entity = new DataEntity();
        entity.setId(data.getId());
        entity.setContent(data.getContent());
        return entity;
    }
}
