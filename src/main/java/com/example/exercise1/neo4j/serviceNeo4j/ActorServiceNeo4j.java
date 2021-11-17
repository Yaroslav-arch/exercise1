package com.example.exercise1.neo4j.serviceNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.ActorNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.ActorRepositoryNeo4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ActorServiceNeo4j {

    private final ActorRepositoryNeo4j actorRepositoryNeo4j;

    @Inject
    public ActorServiceNeo4j(ActorRepositoryNeo4j actorRepositoryNeo4j) {
        this.actorRepositoryNeo4j = actorRepositoryNeo4j;
    }

    public List<ActorNeo4j> getAllActors() {
        return actorRepositoryNeo4j.findAll();
    }

    public List<ActorNeo4j> getAllActorsByMovieName(String movieName) {
        return actorRepositoryNeo4j.getAllActorsByMovieName(movieName);
    }

    public void saveActor(ActorNeo4j actor) {
        actorRepositoryNeo4j.save(actor);
    }
}
