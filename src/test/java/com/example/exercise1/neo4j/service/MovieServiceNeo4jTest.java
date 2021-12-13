package com.example.exercise1.neo4j.service;

import com.example.exercise1.neo4j.entityNeo4j.ActorNeo4j;
import com.example.exercise1.neo4j.entityNeo4j.GenreNeo4j;
import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.MovieRepositoryNeo4j;
import com.example.exercise1.neo4j.serviceNeo4j.MovieServiceNeo4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("neo4j")
public class MovieServiceNeo4jTest {

    @Inject
    private MovieServiceNeo4j movieServiceNeo4j;

    @MockBean
    private static MovieRepositoryNeo4j movieRepositoryNeo4j;

    private final MovieNeo4j movie3 = MovieNeo4j.builder().name("Mad Max").duration(65).build();
    private final MovieNeo4j someMovie = MovieNeo4j.builder().name("Some Movie").duration(65).build();

    @BeforeEach
    public void setUp() {
        ActorNeo4j actorNeo4j = new ActorNeo4j(1L, "Mel Gibson");
        List<ActorNeo4j> actors = new ArrayList<>();
        actors.add(actorNeo4j);
        GenreNeo4j genre = new GenreNeo4j(1L, "action");
        List<GenreNeo4j> genres = new ArrayList<>();
        genres.add(genre);
        MovieNeo4j movie1 = MovieNeo4j.builder().id(1L).name("Mad Max").actors(actors).genres(genres).build();
        MovieNeo4j movie2 = MovieNeo4j.builder().id(2L).name("Lethal Weapon").actors(actors).genres(genres).build();
        List<MovieNeo4j> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);


        Mockito.when(movieRepositoryNeo4j.getAllMoviesByActorsName("Mel Gibson"))
                .thenReturn(movies);

        Mockito.when(movieRepositoryNeo4j.findByName(movie1.getName()))
                .thenReturn(Optional.of(movie3));

        Mockito.when(movieRepositoryNeo4j.findByName(someMovie.getName()))
                .thenReturn(Optional.empty());

        Mockito.doNothing().when(movieRepositoryNeo4j).delete(movie3);
    }

    @Test
    public void getAllMoviesByActorsName() {
        String actorsName = "Mel Gibson";
        Assertions.assertNotNull(movieServiceNeo4j.getAllMoviesByActorsName(actorsName));
    }

    @Test
    public void getAllMoviesByGenre() {
        GenreNeo4j genreNeo4j = new GenreNeo4j(1L, "action");
        Assertions.assertNotNull(movieServiceNeo4j.getAllMoviesByGenreName(genreNeo4j.getName()));
    }

    @Test
    public void saveMovieTestWithDelete() {
        movieServiceNeo4j.saveMovie(movie3);
        verify(movieRepositoryNeo4j, times(1)).findByName(movie3.getName());
        verify(movieRepositoryNeo4j, times(1)).delete(movie3);
        verify(movieRepositoryNeo4j, times(1)).save(movie3);

    }

    @Test
    public void saveMovieTestWithoutDelete() {
        movieServiceNeo4j.saveMovie(someMovie);
        verify(movieRepositoryNeo4j, times(1)).findByName(someMovie.getName());
        verify(movieRepositoryNeo4j, times(1)).save(someMovie);

    }

}
