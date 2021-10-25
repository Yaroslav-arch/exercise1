package com.example.exercise1.service;

import com.example.exercise1.entities.Genre;
import com.example.exercise1.repositories.GenresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresService {
    private final GenresRepository genresRepository;

    public GenresService(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    public List<Genre> getAllGenres(){
        return genresRepository.findAll();
    }

}
