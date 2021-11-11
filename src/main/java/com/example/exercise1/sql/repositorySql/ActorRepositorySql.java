package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.ActorSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepositorySql extends JpaRepository<ActorSql, Long> {

    @Query(nativeQuery = true, value = "SELECT * from Actors WHERE id IN (SELECT id FROM Movies WHERE name_id = :movieName)")
//    @Query(nativeQuery = true, value = "SELECT actors.id, actors.name_id FROM actors INNER JOIN movies on actors.id = movies.actors_id WHERE movies.name_id = :movieName")
    List<ActorSql> getAllActorsByMovieName(@Param("movieName") String movieName);

}