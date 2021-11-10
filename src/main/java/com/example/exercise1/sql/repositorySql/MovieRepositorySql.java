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

//    @Query("MATCH (a:Actor{name:$actorsName})-[:ACTED_IN]->(m:Movie) RETURN m")
//    @Query(nativeQuery = true, value = "SELECT * from Movies RIGHT JOIN Actors on Movies.ACTORS_ID=Actors.ID WHERE ACTORS.name_id = :actorsName")
    @Query(nativeQuery = true, value = "SELECT * from MOVIES WHERE ID IN (SELECT ID FROM ACTORS WHERE NAME_ID = :actorName)")
    List<MovieSql> getAllMoviesByActorsName(@Param("actorsName") String actorsName);

//    @Query("MATCH (g:Genre{name:$genreName})<-[:IN_GENRE]-(m:Movie) RETURN m")
    @Query(nativeQuery=true, value = "SELECT * FROM MOVIES WHERE ID IN (SELECT ID FROM GENRES WHERE NAME_ID = :genreName)")
    List<MovieSql> getAllMoviesByGenreName(@Param("genreName") String genreName);


}
