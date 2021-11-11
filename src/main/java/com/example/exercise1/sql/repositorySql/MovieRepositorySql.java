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

//    @Query(nativeQuery = true, value = "SELECT * from MOVIES WHERE ID IN (SELECT ID FROM ACTORS WHERE NAME_ID = :actorName)")
    @Query(nativeQuery = true, value = "SELECT * from movies INNER JOIN actors ON movies.actors_id=actors.id WHERE actors.name_id = :actorName")
    List<MovieSql> getAllMoviesByActorsName(@Param("actorName") String actorName);

    @Query(nativeQuery=true, value = "SELECT * FROM MOVIES WHERE ID IN (SELECT ID FROM GENRES WHERE NAME_ID = :genreName)")
    List<MovieSql> getAllMoviesByGenreName(@Param("genreName") String genreName);


}
