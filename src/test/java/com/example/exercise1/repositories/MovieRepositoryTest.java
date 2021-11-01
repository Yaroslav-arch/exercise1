package com.example.exercise1.repositories;

import com.example.exercise1.entities.Movie;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import javax.inject.Inject;

@DataNeo4jTest
class MovieRepositoryTest {

    private static Neo4j embeddedDatabaseServer;

    @Inject
    private MovieRepository movieRepository;

    @BeforeAll
    static void initializeNeo4j() {

        embeddedDatabaseServer = Neo4jBuilders.newInProcessBuilder()
                .withFixture("CREATE (:Actor{name:'Mel Gibson'})-[:ACTED_IN]->(:Movie{name:'Mad Max'})-[:IN_GENRE]->(:Genre{name:'Action'})")
                .withDisabledServer()
                .build();


    }

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.neo4j.uri", embeddedDatabaseServer::boltURI);
        registry.add("spring.neo4j.authentication.username", () -> "neo4j");
        registry.add("spring.neo4j.authentication.password", () -> null);
    }

    @AfterAll
    static void stopNeo4j() {

        embeddedDatabaseServer.close();
    }

    @Test
    public void checkReturnOfActorByName() {

        String actorsName = "Mel Gibson";
        Movie actual = new Movie();
        actual.setName("Mad Max");
        actual.setId(1L);
        Movie expected = movieRepository.getAllMoviesByActorsName(actorsName).get(0);
        Assertions.assertEquals(expected.getName(),actual.getName());

    }
}