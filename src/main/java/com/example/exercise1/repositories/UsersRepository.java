package com.example.exercise1.repositories;

import com.example.exercise1.entities.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends Neo4jRepository<User, Long> {
}
