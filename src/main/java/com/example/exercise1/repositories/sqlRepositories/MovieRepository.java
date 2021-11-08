package com.example.exercise1.repositories.sqlRepositories;

import com.example.exercise1.entities.entitiesSQL.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie getMovieByName(String name);

//    @Query("MATCH (a:Actor{name:$actorsName})-[:ACTED_IN]->(m:Movie) RETURN m")
    @Query(nativeQuery = true, value = "SELECT movie from Movies RIGHT JOIN Actors on Movies.ActorID=Actors.ID WHERE actor.name = :actorsName")
    List<Movie> getAllMoviesByActorsName(@Param("actorsName") String actorsName);

//    @Query("MATCH (g:Genre{name:$genreName})<-[:IN_GENRE]-(m:Movie) RETURN m")
    @Query(nativeQuery=true, value = "SELECT movie FROM Movies RIGHT JOIN Genres on Movies.GenreID=Genres.ID WHERE genre.name = :genreName")
    List<Movie> getAllMoviesByGenreName(@Param("genreName") String genreName);


}
