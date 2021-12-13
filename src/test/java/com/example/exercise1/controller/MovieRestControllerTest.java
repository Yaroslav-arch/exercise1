package com.example.exercise1.controller;

import com.example.exercise1.dto.MovieDTO;
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
import java.util.Objects;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieRestController.class)
@Import(MovieRestController.class)
class MovieRestControllerTest {

    List<MovieDTO> movies = new ArrayList<>();
    String actorName = "Keanu Reeves";
    String movieName = "Matrix";
    String genreName = "action";
    MovieDTO movie = MovieDTO.builder().id(1L).name(movieName).duration(90).build();
    MovieDTO movie1 = MovieDTO.builder().id(2L).name("John Wick").duration(101).build();
    {


        movies.add(movie);
        movies.add(movie1);

    }

    @Inject
    private MockMvc mockMvc;

    @MockBean
    private MainService mainService;

    @Test
    void getMovieByNameTest() throws Exception {

        given(mainService.getMovieByName(movieName)).willReturn(movie);

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

        given(mainService.getAllMoviesByActorsName(actorName)).willReturn(movies);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/actor")
                        .param("actorName", "Keanu Reeves"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[*]['name']").value(containsInAnyOrder("Matrix", "John Wick")));
    }

    @Test
    void getMoviesByGenreTest() throws Exception {

        given(mainService.getAllMoviesByGenreName(genreName)).willReturn(movies);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/action"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[*]['name']").value(containsInAnyOrder("Matrix", "John Wick")));
    }
}