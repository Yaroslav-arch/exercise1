package com.example.exercise1.controller;

import com.example.exercise1.dto.ActorDTO;
import com.example.exercise1.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ActorRestController.class)
@Import(ActorRestController.class)
class ActorRestControllerTest {

    List<ActorDTO> actors = new ArrayList<>();
    String movieName = "Matrix";

    {
        ActorDTO actor = new ActorDTO(1L, "Keanu Reeves");
        ActorDTO actor1 = new ActorDTO(2L, "Hugo Weaving");
        actors.add(actor);
        actors.add(actor1);

    }

    @Inject
    private MockMvc mockMvc;

    @MockBean
    private MainService mainService;

    @Test
    void getAllActorsTest() throws Exception {

        given(mainService.getAllActors()).willReturn(actors);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/actors/all"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[*]['name']").value(containsInAnyOrder("Hugo Weaving", "Keanu Reeves")));

    }

    @Test
    void getAllActorsByMovieNameTest() throws Exception {

        given(mainService.getAllActorsByMovieName(movieName)).willReturn(actors);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/actors/Matrix"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[*]['name']").value(containsInAnyOrder("Hugo Weaving", "Keanu Reeves")));
    }
}