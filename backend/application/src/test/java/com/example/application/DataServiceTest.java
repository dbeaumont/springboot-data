package com.example.application;

import com.example.domain.Data;
import com.example.domain.DataStatus;
import com.example.domain.port.IDataPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataServiceTest {
    @Test
    void shouldGetMessage() {
        IDataPort mockAdapter = mock(IDataPort.class);
        when(mockAdapter.getData()).thenReturn(new Data("test", DataStatus.PENDING));
        DataService service = new DataService(mockAdapter);
        assertEquals("test", service.getMessage().getContent());
    }
}
