package com.example.exercise1.services.servicesNeo4j;

import com.example.exercise1.entities.entitiesNeo4j.Director;
import com.example.exercise1.repositories.neo4jrepositories.DirectorRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Inject
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

}
