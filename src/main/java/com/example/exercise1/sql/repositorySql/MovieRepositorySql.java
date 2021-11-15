package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.MovieSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositorySql extends JpaRepository<MovieSql, Long> {

    MovieSql getMovieByName(String name);

//    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name_id, movies.duration from movies WHERE id IN (SELECT id FROM actors WHERE NAME_ID = :actorName)")
    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name_id, movies.duration\n" +
            "FROM movies\n" +
            "JOIN acted_in ON movies.id = acted_in.movie_id\n" +
            "JOIN actors on acted_in.actor_id = actors.id AND actors.name_id = :actorName")
    List<MovieSql> getAllMoviesByActorsName(@Param("actorName") String actorName);

    @Query(nativeQuery=true, value = "SELECT movies.id, movies.name_id, movies.duration FROM movies WHERE id IN (SELECT id FROM genres WHERE NAME_ID = :genreName)")
    List<MovieSql> getAllMoviesByGenreName(@Param("genreName") String genreName);


}
