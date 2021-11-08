package com.example.exercise1.repositories.neo4jrepositories;

import com.example.exercise1.entities.entitiesNeo4j.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
}
