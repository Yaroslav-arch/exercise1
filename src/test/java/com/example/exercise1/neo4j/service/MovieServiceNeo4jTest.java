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

@SpringBootTest
public class MovieServiceNeo4jTest {

    @Inject
    private MovieServiceNeo4j movieServiceNeo4j;

    @MockBean
    private static MovieRepositoryNeo4j movieRepositoryNeo4j;

    @Before
    public void setUp() {
        ActorNeo4j actorNeo4j = new ActorNeo4j();
        actorNeo4j.setName("Mel Gibson");
        List<ActorNeo4j> actorNeo4jList = new ArrayList<>();
        actorNeo4jList.add(actorNeo4j);
        GenreNeo4j genreNeo4j = new GenreNeo4j();
        genreNeo4j.setName("Action");
        List<GenreNeo4j> genreNeo4js = new ArrayList<>();
        genreNeo4js.add(genreNeo4j);
        MovieNeo4j movieNeo4j1 = new MovieNeo4j();
        movieNeo4j1.setName("Mad Max");
        movieNeo4j1.setActors(actorNeo4jList);
        movieNeo4j1.setGenres(genreNeo4js);
        MovieNeo4j movieNeo4j2 = new MovieNeo4j();
        movieNeo4j2.setName("Lethal weapon");
        movieNeo4j2.setActors(actorNeo4jList);
        movieNeo4j2.setGenres(genreNeo4js);
        List<MovieNeo4j> movieNeo4js = new ArrayList<>();
        movieNeo4js.add(movieNeo4j1);
        movieNeo4js.add(movieNeo4j2);


        Mockito.when(movieRepositoryNeo4j.getAllMoviesByActorsName("Mel Gibson"))
                .thenReturn(movieNeo4js);
    }

    @Test
    public void getAllMoviesByActorsName() {
        String actorsName = "Mel Gibson";
        Assertions.assertNotNull(movieServiceNeo4j.getAllMoviesByActorsName(actorsName));
    }

    @Test
    public void getAllMoviesByGenre() {
        GenreNeo4j genreNeo4j = new GenreNeo4j();
        genreNeo4j.setName("Action");
        Assertions.assertNotNull(movieServiceNeo4j.getAllMoviesByGenreName(genreNeo4j.getName()));
    }
}
