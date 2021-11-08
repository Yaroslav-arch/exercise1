package com.example.exercise1.repositories.sqlRepositories;

import com.example.exercise1.entities.entitiesSQL.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

//    @Query("MATCH (m:Movie{name:$name})<-[:ACTED_IN]-(a:Actor) RETURN a")
    @Query(nativeQuery = true, value = "SELECT actor from Actors RIGHT JOIN Movies on Movies.ActorID=Actors.ID WHERE movie.name = :movieName")
    List<Actor> getAllActorsByMovieName(@Param("movieName")String movieName);

}