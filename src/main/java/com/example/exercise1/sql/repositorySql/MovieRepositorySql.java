package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.neo4j.entityNeo4j.MovieNeo4j;
import com.example.exercise1.sql.entitySql.MovieSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepositorySql extends JpaRepository<MovieSql, Long> {

    MovieSql getMovieByName(String name);


//    @Query(nativeQuery = true, value = "SELECT movie.id, movie.movie_name, movie.duration " +
//            "FROM movie " +
//            "JOIN acted_in ON movie.id = acted_in.movie_id " +
//            "JOIN actor on acted_in.actor_id = actor.id AND actor.actor_name = :actorName")
//    List<MovieSql> getAllMoviesByActorsName(@Param("actorName") String actorName);
    List<MovieSql> getByActors_Name(String actorName);

//    @Query(nativeQuery=true, value = "SELECT movie.id, movie.movie_name, movie.duration " +
//            "FROM movie " +
//            "INNER JOIN movies_of_genre ON movie.id = movies_of_genre.movie_id " +
//            "INNER JOIN genre on genre.id = movies_of_genre.genre_id AND genre.genre_name = :genreName")
//    List<MovieSql> getAllMoviesByGenreName(@Param("genreName") String genreName);
    List<MovieSql> getByGenres_Name(String genreName);

    Optional<MovieNeo4j> findByName(String name);
}
