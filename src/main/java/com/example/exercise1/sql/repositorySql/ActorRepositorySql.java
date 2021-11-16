package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.ActorSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepositorySql extends JpaRepository<ActorSql, Long> {

    @Query(nativeQuery = true, value = "SELECT actor.id, actor.actor_name " +
            "FROM actor " +
            "INNER JOIN acted_in ON actor.id = acted_in.actor_id " +
            "INNER JOIN movie ON acted_in.movie_id = movie.id AND movie.movie_name = :movieName")
    List<ActorSql> getAllActorsByMovieName(@Param("movieName") String movieName);

    List<ActorSql> getByMovies_Name(String movieName);//analogue of top method
}