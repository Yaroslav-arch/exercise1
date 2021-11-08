package com.example.exercise1.repositories.neo4jrepositories;

import com.example.exercise1.entities.entitiesNeo4j.Genre;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends Neo4jRepository<Genre, Long> {

    Genre getGenreByName(String name);
}
