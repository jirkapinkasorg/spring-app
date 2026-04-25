package com.example.spring_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PersonCachingTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private MyService myService;

    @Test
    void getPerson_cachedAfterFirstCall() throws Exception {
        mockMvc.perform(get("/person")).andExpect(status().isOk());
        mockMvc.perform(get("/person")).andExpect(status().isOk());

        verify(myService, times(1)).getPerson();
    }
}
