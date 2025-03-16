package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CorsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAllowCorsFromLocalhost() throws Exception {
        mockMvc.perform(get("/api/data")
                        .header("Origin", "http://localhost:4200"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAllowCorsFromFrontend() throws Exception {
        mockMvc.perform(get("/api/data")
                        .header("Origin", "http://frontend:4200"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldBlockCorsFromOtherOrigins() throws Exception {
        mockMvc.perform(get("/api/data")
                        .header("Origin", "http://invalid-origin"))
                .andExpect(status().isForbidden());
    }

}
