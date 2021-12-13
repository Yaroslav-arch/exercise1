package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.GenreSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepositorySql extends JpaRepository<GenreSql, Long> {

    GenreSql getGenreByName(String name);
}
