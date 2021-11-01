package com.example.exercise1.repositories;

import com.example.exercise1.entities.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {

    @Query("MATCH (m:Movie{name:$name})<-[:ACTED_IN]-(a:Actor) RETURN a")
    List<Actor> getAllActorsByMovieName(String name);

}