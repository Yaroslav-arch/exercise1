package com.example.exercise1.services.servicesSQL;

import com.example.exercise1.entities.entitiesSQL.Director;
import com.example.exercise1.repositories.sqlRepositories.DirectorRepository;
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
