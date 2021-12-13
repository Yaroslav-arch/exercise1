package com.example.exercise1.neo4j.repositoryNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.DirectorNeo4j;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepositoryNeo4j extends Neo4jRepository<DirectorNeo4j, Long> {

}
