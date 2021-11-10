package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.ActorSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepositorySql extends JpaRepository<ActorSql, Long> {

    @Query(nativeQuery = true, value = "SELECT * from Actors WHERE ID IN (SELECT Id FROM Movies WHERE NAME_ID = :movieName)")
    List<ActorSql> getAllActorsByMovieName(@Param("movieName")String movieName);

}