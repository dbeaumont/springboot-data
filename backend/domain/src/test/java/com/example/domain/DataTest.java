package com.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTest {
    @Test
    void shouldCreateMessage() {
        Data message = new Data();
        message.setContent("test");
        assertEquals("test", message.getContent());
    }
}