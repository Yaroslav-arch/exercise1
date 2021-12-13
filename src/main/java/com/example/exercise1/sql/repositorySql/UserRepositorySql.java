package com.example.exercise1.sql.repositorySql;

import com.example.exercise1.sql.entitySql.UserSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorySql extends JpaRepository<UserSql, Long> {
}
