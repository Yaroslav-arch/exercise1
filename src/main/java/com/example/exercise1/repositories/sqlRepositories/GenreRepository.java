package com.example.exercise1.repositories.sqlRepositories;

import com.example.exercise1.entities.entitiesSQL.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre getGenreByName(String name);
}
