package com.example.exercise1.neo4j.service;

import com.example.exercise1.neo4j.MainServiceNeo4j;
import com.example.exercise1.neo4j.entityNeo4j.ActorNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.ActorRepositoryNeo4j;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("neo4j")
public class ActorServiceNeo4jTest {

    @Inject
    private MainServiceNeo4j mainService;

    @MockBean
    private static ActorRepositoryNeo4j actorRepositoryNeo4j;

    @Before
    public void setUp() {
        ActorNeo4j actor = new ActorNeo4j(1L, "Mel Gibson");
        List<ActorNeo4j> actors = new ArrayList<>();
        actors.add(actor);

        Mockito.when(actorRepositoryNeo4j.getAllActorsByMovieName("Mad Max"))
                .thenReturn(actors);
    }

    @Test
    public void getAllActorsByMovieName() {
        String movieName = "Mad Max";
        Assertions.assertNotNull(mainService.getAllActorsByMovieName(movieName));
    }

}
