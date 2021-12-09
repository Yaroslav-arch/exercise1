package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.UserSql;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("postgres")
public interface UserRepositorySql extends JpaRepository<UserSql, Long> {
}
