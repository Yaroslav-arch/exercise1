package com.example.exercise1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.inject.Inject;
import java.util.Objects;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieNeo4jRestControllerTest{

    @Inject
    private MockMvc mockMvc;

    @Test
    void getMovieByNameTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/movie/Matrix"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$['name']").value("Matrix"));
    }

    @Test
    void getMovieByNameTestNull() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/movie/null"))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertNotNull(result.getResolvedException()))
                .andExpect(result -> assertEquals("Null can't be the name of the movie", Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }

    @Test
    void getAllMoviesByActorsNameTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/actor")
                        .param("actorName", "Keanu Reeves"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[*]['name']").value(containsInAnyOrder("Matrix", "John Wick")));
    }

    @Test
    void getMoviesByGenreTest() throws Exception {//TODO
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/Action"))
                .andDo(print()).andExpect(status().isOk());
//                .andExpect(jsonPath("$[*]['name']").value(containsInAnyOrder("Matrix", "John Wick")));
    }
}