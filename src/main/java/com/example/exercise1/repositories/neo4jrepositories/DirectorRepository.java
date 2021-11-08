package com.example.exercise1.repositories.neo4jrepositories;

import com.example.exercise1.entities.entitiesNeo4j.Director;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends Neo4jRepository<Director, Long> {

}
