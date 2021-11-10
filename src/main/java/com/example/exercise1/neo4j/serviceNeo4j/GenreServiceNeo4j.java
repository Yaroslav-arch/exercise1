package com.example.exercise1.neo4j.serviceNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.GenreNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.GenreRepositoryNeo4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GenreServiceNeo4j {
    private final GenreRepositoryNeo4j genreRepositoryNeo4j;

    @Inject
    public GenreServiceNeo4j(GenreRepositoryNeo4j genreRepositoryNeo4j) {
        this.genreRepositoryNeo4j = genreRepositoryNeo4j;
    }

    public List<GenreNeo4j> getAllGenres(){
        return genreRepositoryNeo4j.findAll();
    }

    public GenreNeo4j getGenreByName(String name){
        return genreRepositoryNeo4j.getGenreByName(name);
    }

}
