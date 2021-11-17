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
        ActorNeo4j actorNeo4j = new ActorNeo4j(1L,"Mel Gibson");
        List<ActorNeo4j> actorNeo4jList = new ArrayList<>();
        actorNeo4jList.add(actorNeo4j);
        GenreNeo4j genreNeo4j = new GenreNeo4j(1L, "action");
        List<GenreNeo4j> genreNeo4js = new ArrayList<>();
        genreNeo4js.add(genreNeo4j);
        MovieNeo4j movieNeo4j1 = MovieNeo4j.builder().id(1L).name("Mad Max").actors(actorNeo4jList).genres(genreNeo4js).build();
        MovieNeo4j movieNeo4j2 = MovieNeo4j.builder().id(2L).name("Lethal Weapon").actors(actorNeo4jList).genres(genreNeo4js).build();
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
        GenreNeo4j genreNeo4j = new GenreNeo4j(1L, "action");
        Assertions.assertNotNull(movieServiceNeo4j.getAllMoviesByGenreName(genreNeo4j.getName()));
    }
}
