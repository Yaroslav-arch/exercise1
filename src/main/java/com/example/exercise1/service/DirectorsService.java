package com.example.exercise1.service;

import com.example.exercise1.entities.Director;
import com.example.exercise1.repositories.DirectorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorsService {
    private final DirectorsRepository directorsRepository;

    public DirectorsService(DirectorsRepository directorsRepository) {
        this.directorsRepository = directorsRepository;
    }

    public List<Director> getAllDirectors() {
        return directorsRepository.findAll();
    }

}
