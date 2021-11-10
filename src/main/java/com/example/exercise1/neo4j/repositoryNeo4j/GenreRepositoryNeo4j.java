package com.example.exercise1.neo4j.repositoryNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.GenreNeo4j;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepositoryNeo4j extends Neo4jRepository<GenreNeo4j, Long> {

    GenreNeo4j getGenreByName(String name);
}
