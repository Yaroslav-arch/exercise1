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
        ActorNeo4j actor = new ActorNeo4j();
        actor.setName("Mel Gibson");
        List<ActorNeo4j> actors = new ArrayList<>();
        actors.add(actor);
        GenreNeo4j genre = new GenreNeo4j();
        genre.setName("action");
        List<GenreNeo4j> genres = new ArrayList<>();
        genres.add(genre);
        MovieNeo4j movie1 = new MovieNeo4j();
        movie1.setName("Mad Max");
        movie1.setActors(actors);
        movie1.setGenres(genres);
        MovieNeo4j movie2 = new MovieNeo4j();
        movie2.setName("Lethal weapon");
        movie2.setActors(actors);
        movie2.setGenres(genres);

        Mockito.when(actorRepositoryNeo4j.getAllActorsByMovieName("Mad Max"))
                .thenReturn(actors);
    }

    @Test
    public void getAllActorsByMovieName() {
        String movieName = "Mad Max";
        Assertions.assertNotNull(actorServiceNeo4j.getAllActorsByMovieName(movieName));
    }

}
