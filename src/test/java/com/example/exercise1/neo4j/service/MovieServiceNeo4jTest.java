package com.example.exercise1.neo4j.service;

import com.example.exercise1.neo4j.entityNeo4j.ActorNeo4j;
import com.example.exercise1.neo4j.entityNeo4j.GenreNeo4j;
import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.MovieRepositoryNeo4j;
import com.example.exercise1.neo4j.serviceNeo4j.MovieServiceNeo4j;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MovieServiceNeo4jTest {

    @Inject
    private MovieServiceNeo4j movieServiceNeo4j;

    @MockBean
    private static MovieRepositoryNeo4j movieRepositoryNeo4j;

    @Before
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

        Mockito.when(movieRepositoryNeo4j.findByName("Some Movie"))
                .thenReturn(Optional.of(MovieNeo4j.builder().name("Some Movie").duration(65).build()));
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

//    @Test
//    public void saveMovieTest() {
//        MovieNeo4j movie = MovieNeo4j.builder().name("Some Movie").duration(65).build();
//        MovieNeo4j savedMovie = movieServiceNeo4j.getMovieByName(movie.getName());
//        assertThat(movie).usingRecursiveComparison().isEqualTo(savedMovie);
//    }

//    @Test
//    public void
}
