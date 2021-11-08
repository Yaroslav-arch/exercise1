package com.example.exercise1.services.servicesSQL;

import com.example.exercise1.entities.entitiesSQL.Actor;
import com.example.exercise1.repositories.sqlRepositories.ActorRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Inject
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public List<Actor> getAllActorsByMovieName(String movieName) {
        return actorRepository.getAllActorsByMovieName(movieName);
    }
}
