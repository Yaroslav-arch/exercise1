package com.example.exercise1.neo4j.repositoryNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositoryNeo4j extends Neo4jRepository<MovieNeo4j, Long> {

    MovieNeo4j getMovieByName(String name);

    @Query("MATCH (:Actor{name:$actorsName})-[:ACTED_IN]->(m:Movie) RETURN m")
    List<MovieNeo4j> getAllMoviesByActorsName(String actorsName);

    @Query("MATCH (:Genre{name:$genreName})<-[:IN_GENRE]-(m:Movie) RETURN m")
    List<MovieNeo4j> getAllMoviesByGenreName(String genreName);

}
