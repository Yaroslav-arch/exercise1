package com.example.exercise1.repositories;

import com.example.exercise1.entities.Director;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorsRepository extends Neo4jRepository<Director, Long> {

}
