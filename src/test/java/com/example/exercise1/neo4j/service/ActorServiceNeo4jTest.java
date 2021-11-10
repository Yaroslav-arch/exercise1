package com.example.exercise1.neo4j.service;

import com.example.exercise1.neo4j.entityNeo4j.ActorNeo4j;
import com.example.exercise1.neo4j.entityNeo4j.GenreNeo4j;
import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.ActorRepositoryNeo4j;
import com.example.exercise1.neo4j.serviceNeo4j.ActorServiceNeo4j;
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
public class ActorServiceNeo4jTest {

    @Inject
    private ActorServiceNeo4j actorServiceNeo4j;

    @MockBean
    private static ActorRepositoryNeo4j actorRepositoryNeo4j;

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
        movieNeo4j1.setActorNeo4js(actorNeo4jList);
        movieNeo4j1.setGenreNeo4js(genreNeo4js);
        MovieNeo4j movieNeo4j2 = new MovieNeo4j();
        movieNeo4j2.setName("Lethal weapon");
        movieNeo4j2.setActorNeo4js(actorNeo4jList);
        movieNeo4j2.setGenreNeo4js(genreNeo4js);

        Mockito.when(actorRepositoryNeo4j.getAllActorsByMovieName("Mad Max"))
                .thenReturn(actorNeo4jList);
    }

    @Test
    public void getAllActorsByMovieName() {
        String movieName = "Mad Max";
        Assertions.assertNotNull(actorServiceNeo4j.getAllActorsByMovieName(movieName));
    }

}
