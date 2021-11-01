package com.example.exercise1.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ActorRestControllerTest {

    @Inject
    private MockMvc mockMvc;

    @Test
    void getAllActorsTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/actors/all"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllActorsByMovieName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/actors/matrix"))
                .andDo(print()).andExpect(status().isOk());
    }
}