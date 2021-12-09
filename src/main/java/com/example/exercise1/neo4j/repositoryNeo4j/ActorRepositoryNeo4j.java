package com.example.exercise1.neo4j.repositoryNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.ActorNeo4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("neo4j")
public interface ActorRepositoryNeo4j extends Neo4jRepository<ActorNeo4j, Long> {

    @Query("MATCH (m:Movie{name:$name})<-[:ACTED_IN]-(a:Actor) RETURN a")
    List<ActorNeo4j> getAllActorsByMovieName(String name);

}