package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.DirectorSql;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("postgres")
public interface DirectorRepositorySql extends JpaRepository<DirectorSql, Long> {
}
