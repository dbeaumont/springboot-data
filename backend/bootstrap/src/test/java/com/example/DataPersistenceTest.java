package com.example;

import com.example.domain.DataStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import com.example.infrastructure.repository.DataEntity;
import com.example.infrastructure.repository.DataRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DataPersistenceTest {

    @Autowired
    private DataRepository dataRepository;

    @Test
    @Sql("/data.sql")
    void shouldLoadInitialMessage() {
        // When
        DataEntity data = dataRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);

        // Then
        assertThat(data).isNotNull();
        assertThat(data.getContent()).isEqualTo("Premier élément de données");
    }

    @Test
    void shouldSaveAndRetrieveMessage() {
        // Given
        DataEntity dataToSave = new DataEntity("Test Data", DataStatus.PENDING);

        // When
        DataEntity savedData = dataRepository.save(dataToSave);
        DataEntity retrievedData = dataRepository.findById(savedData.getId()).orElse(null);

        // Then
        assertThat(retrievedData).isNotNull();
        assertThat(retrievedData.getContent()).isEqualTo("Test Data");
    }
}
