package com.example.exercise1.controller;

import com.example.exercise1.neo4j.BasicNeo4jTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.inject.Inject;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ActorNeo4jRestControllerTest{//TODO

    @Inject
    private MockMvc mockMvc;

    @Test
    void getAllActorsTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/actors/all"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[*]",hasSize(2)))
                .andExpect(jsonPath("$[*]['name']").value(containsInAnyOrder("Hugo Weaving", "Keanu Reeves")));

    }

    @Test
    void getAllActorsByMovieNameTest() throws Exception { //TODO
        this.mockMvc.perform(MockMvcRequestBuilders.get("/actors/Matrix"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[*]",hasSize(2)))
                .andExpect(jsonPath("$[*]['name']").value(containsInAnyOrder("Hugo Weaving", "Keanu Reeves")));
    }
}