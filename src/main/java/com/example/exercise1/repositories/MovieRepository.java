package com.example.exercise1.repositories;

import com.example.exercise1.entities.Actor;
import com.example.exercise1.entities.Genre;
import com.example.exercise1.entities.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie,Long>{

    Movie getMovieByName(String name);

    List<Movie> getAllMoviesByActors(Actor actor);

    List<Movie> getAllMoviesByGenres(Genre genre);

}
