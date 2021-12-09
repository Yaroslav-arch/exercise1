package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.MovieSql;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("postgres")
public interface MovieRepositorySql extends JpaRepository<MovieSql, Long> {

    MovieSql getMovieByName(String name);

    List<MovieSql> getByActors_Name(String actorName);

    List<MovieSql> getByGenres_Name(String genreName);

    Optional<MovieSql> findByName(String name);
}
