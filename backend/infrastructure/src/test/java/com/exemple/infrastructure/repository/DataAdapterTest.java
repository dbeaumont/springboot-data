package com.exemple.infrastructure.repository;

import com.example.domain.Data;
import com.example.infrastructure.repository.DataAdapter;
import com.example.infrastructure.repository.DataMapper;
import com.example.infrastructure.repository.DataEntity;
import com.example.infrastructure.repository.DataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DataAdapterTest {
    @Mock
    private DataRepository dataRepository;

    @Mock
    private DataMapper dataMapper;

    @InjectMocks
    private DataAdapter messageAdapter;

    @Test
    void shouldReturnMessageWhenRepositoryHasData() {
        // Given
        DataEntity dataEntity = new DataEntity();
        dataEntity.setId(1L);
        dataEntity.setContent("Hello World");

        Data expectedData = new Data();
        expectedData.setId(1L);
        expectedData.setContent("Hello World");

        when(dataRepository.findAll()).thenReturn(List.of(dataEntity));
        when(dataMapper.toData(dataEntity)).thenReturn(expectedData);

        // When
        Data result = messageAdapter.getData();

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getContent()).isEqualTo("Hello World");
        verify(dataRepository).findAll();
        verify(dataMapper).toData(dataEntity);
    }

    @Test
    void shouldReturnNullWhenRepositoryIsEmpty() {
        // Given
        when(dataRepository.findAll()).thenReturn(Collections.emptyList());

        // When
        Data result = messageAdapter.getData();

        // Then
        assertThat(result).isNull();
        verify(dataRepository).findAll();
        verifyNoInteractions(dataMapper);
    }
}
