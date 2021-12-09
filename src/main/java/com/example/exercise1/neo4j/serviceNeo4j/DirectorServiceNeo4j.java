package com.example.exercise1.neo4j.serviceNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.DirectorNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.DirectorRepositoryNeo4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@Profile("neo4j")
public class DirectorServiceNeo4j {
    private final DirectorRepositoryNeo4j directorRepositoryNeo4j;

    @Inject
    public DirectorServiceNeo4j(DirectorRepositoryNeo4j directorRepositoryNeo4j) {
        this.directorRepositoryNeo4j = directorRepositoryNeo4j;
    }

    public List<DirectorNeo4j> getAllDirectors() {
        return directorRepositoryNeo4j.findAll();
    }

    public void saveDirector(DirectorNeo4j director) {
        directorRepositoryNeo4j.save(director);
    }
}
