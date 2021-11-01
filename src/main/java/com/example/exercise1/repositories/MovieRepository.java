package com.example.exercise1.repositories;

import com.example.exercise1.entities.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie getMovieByName(String name);

    @Query("MATCH (a:Actor{name:$actorsName})-[:ACTED_IN]->(m:Movie) RETURN m")
    List<Movie> getAllMoviesByActorsName(String actorsName);

    @Query("MATCH (g:Genre{name:$genreName})<-[:IN_GENRE]-(m:Movie) RETURN m")
    List<Movie> getAllMoviesByGenreName(String genreName);

}
