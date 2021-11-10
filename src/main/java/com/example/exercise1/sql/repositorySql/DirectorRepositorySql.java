package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.DirectorSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepositorySql extends JpaRepository<DirectorSql, Long> {
}
