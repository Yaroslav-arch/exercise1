package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.ActorSql;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("postgres")
public interface ActorRepositorySql extends JpaRepository<ActorSql, Long> {
    List<ActorSql> getByMovies_Name(String movieName);
}