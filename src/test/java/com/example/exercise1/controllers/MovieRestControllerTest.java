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
class MovieRestControllerTest {

    @Inject
    private MockMvc mockMvc;

    @Test
    void getMovieByName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/movie/Matrix"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllMoviesByActorsName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/actor")
                        .param("actorName", "Mel Gibson"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getMoviesByGenre() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/Action"))
                .andDo(print()).andExpect(status().isOk());
    }
}