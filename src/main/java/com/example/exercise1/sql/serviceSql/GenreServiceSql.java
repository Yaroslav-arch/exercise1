package com.example.exercise1.sql.serviceSql;

import com.example.exercise1.sql.entitySql.GenreSql;
import com.example.exercise1.sql.repositorySql.GenreRepositorySql;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GenreServiceSql {
    private final GenreRepositorySql genreRepositorySql;

    @Inject
    public GenreServiceSql(GenreRepositorySql genreRepositorySql) {
        this.genreRepositorySql = genreRepositorySql;
    }

    public List<GenreSql> getAllGenres() {
        return genreRepositorySql.findAll();
    }

    public GenreSql getGenreByName(String name) {
        return genreRepositorySql.getGenreByName(name);
    }
}
