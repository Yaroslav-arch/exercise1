package com.example.exercise1.repositories.sqlRepositories;

import com.example.exercise1.entities.entitiesSQL.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
