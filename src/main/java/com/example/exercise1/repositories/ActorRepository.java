package com.example.exercise1.repositories;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.entities.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {

    Actor getActorByName(String name);

    List<Actor> getAllActorsByMovies(Movie movie);

}