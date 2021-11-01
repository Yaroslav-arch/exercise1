package com.example.exercise1.services;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.entities.Genre;
import com.example.exercise1.entities.Movie;
import com.example.exercise1.repositories.MovieRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MovieServiceTest {

    @Inject
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;

    @Before
    public void setUp() {
        Actor actor = new Actor();
        actor.setName("Mel Gibson");
        List<Actor> actorList = new ArrayList<>();
        actorList.add(actor);
        Genre genre = new Genre();
        genre.setName("Action");
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);
        Movie movie1 = new Movie();
        movie1.setName("Mad Max");
        movie1.setActors(actorList);
        movie1.setGenres(genres);
        Movie movie2 = new Movie();
        movie2.setName("Lethal weapon");
        movie2.setActors(actorList);
        movie2.setGenres(genres);
        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);


        Mockito.when(movieRepository.getAllMoviesByActorsName("Mel Gibson"))
                .thenReturn(movies);
    }

    @Test
    public void getAllMoviesByActorsName() {
        String actorsName = "Mel Gibson";

        Assertions.assertNotNull(movieService.getAllMoviesByActorsName(actorsName));
    }

    @Test
    public void getAllMoviesByGenre() {
        Genre genre = new Genre();
        genre.setName("Action");
        Assertions.assertNotNull(movieService.getAllMoviesByGenreName(genre.getName()));
    }
}
