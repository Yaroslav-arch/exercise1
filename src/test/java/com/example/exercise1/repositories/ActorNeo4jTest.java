package com.example.exercise1.repositories;

import com.example.exercise1.BasicNeo4jTest;
import com.example.exercise1.entities.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import javax.inject.Inject;
import java.util.List;

@DataNeo4jTest
class ActorNeo4jTest extends BasicNeo4jTest {

    @Inject
    private ActorRepository actorRepository;

    @Test
    public void getAllActorsByMovieNameTest() {

        String movieName = "Matrix";
        String actor1Name = "Keanu Reeves";
        String actor2Name = "Hugo Weaving";
        List<Actor> actors = actorRepository.getAllActorsByMovieName(movieName);

        Assertions.assertEquals(actors.size(), 2);
        Assertions.assertNotEquals(actors.get(0), actors.get(1));
        Assertions.assertTrue(actors.stream().map(Actor::getName).anyMatch(actor1Name::equals));
        Assertions.assertTrue(actors.stream().map(Actor::getName).anyMatch(actor2Name::equals));
    }
}