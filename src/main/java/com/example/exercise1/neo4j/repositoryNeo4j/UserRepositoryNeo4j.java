package com.example.exercise1.neo4j.repositoryNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.UserNeo4j;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryNeo4j extends Neo4jRepository<UserNeo4j, Long> {
}
