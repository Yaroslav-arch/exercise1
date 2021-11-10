package com.example.exercise1.neo4j.repositories;

import com.example.exercise1.neo4j.BasicNeo4jTest;
import com.example.exercise1.neo4j.entityNeo4j.ActorNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.ActorRepositoryNeo4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import javax.inject.Inject;
import java.util.List;

@DataNeo4jTest
class ActorNeo4JTest extends BasicNeo4jTest {

    @Inject
    private ActorRepositoryNeo4j actorRepositoryNeo4j;

    @Test
    public void getAllActorsByMovieNameTest() {

        String movieName = "Matrix";
        String actor1Name = "Keanu Reeves";
        String actor2Name = "Hugo Weaving";
        List<ActorNeo4j> actorNeo4js = actorRepositoryNeo4j.getAllActorsByMovieName(movieName);

        Assertions.assertEquals(actorNeo4js.size(), 2);
        Assertions.assertNotEquals(actorNeo4js.get(0), actorNeo4js.get(1));
        Assertions.assertTrue(actorNeo4js.stream().map(ActorNeo4j::getName).anyMatch(actor1Name::equals));
        Assertions.assertTrue(actorNeo4js.stream().map(ActorNeo4j::getName).anyMatch(actor2Name::equals));
    }
}