package com.example.exercise1.services.servicesSQL;

import com.example.exercise1.entities.entitiesSQL.Genre;
import com.example.exercise1.repositories.sqlRepositories.GenreRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    @Inject
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreByName(String name) {
        return genreRepository.getGenreByName(name);
    }
}
