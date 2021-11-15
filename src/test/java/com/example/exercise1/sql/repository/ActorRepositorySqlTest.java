package com.example.exercise1.sql.repository;

import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.repositorySql.ActorRepositorySql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import javax.inject.Inject;
import java.util.List;

@DataJpaTest
@TestPropertySource(locations = "/application-test.properties", properties = {"datasource.rdbms=true"})
public class ActorRepositorySqlTest {

    @Inject
    private ActorRepositorySql actorRepositorySql;

    @Test
    public void getAllActorsByMovieNameTest() {
        String movieName = "John Wick";
        String actorName = "Keanu Reeves";
        List<ActorSql> actorsSql = actorRepositorySql.getAllActorsByMovieName(movieName);

        Assertions.assertEquals(1, actorsSql.size());
        Assertions.assertEquals(actorName, actorsSql.get(0).getName());
    }
}
