package com.example.exercise1.sql.serviceSql;

import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.repositorySql.ActorRepositorySql;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ActorServiceSql {

    private final ActorRepositorySql actorRepositorySql;

    @Inject
    public ActorServiceSql(ActorRepositorySql actorRepositorySql) {
        this.actorRepositorySql = actorRepositorySql;
    }

    public List<ActorSql> getAllActors() {
        return actorRepositorySql.findAll();
    }

    public List<ActorSql> getAllActorsByMovieName(String movieName) {
        return actorRepositorySql.getAllActorsByMovieName(movieName);
    }

    public void saveActor(ActorSql actor) {
        actorRepositorySql.save(actor);
    }
}
