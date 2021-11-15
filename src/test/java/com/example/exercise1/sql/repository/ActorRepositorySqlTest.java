package com.example.exercise1.sql.repository;

import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.entitySql.MovieSql;
import com.example.exercise1.sql.repositorySql.ActorRepositorySql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.util.List;

@SpringBootTest(properties = {"datasource.rdbms=true"})
public class ActorRepositorySqlTest {

    @Inject
    private ActorRepositorySql actorRepositorySql;

    @Test
    public void getAllActorsByMovieNameTest() {
        String movieName = "John Wick";
        String actorName = "Keanu Reeves";
        String actorName1 = "Hugo Weaving";
        List<ActorSql> actorsSql = actorRepositorySql.getAllActorsByMovieName(movieName);

        Assertions.assertEquals(2, actorsSql.size());
//        Assertions.assertEquals(actorName, actorsSql.get(0).getName());
        Assertions.assertTrue(actorsSql.stream().map(ActorSql::getName).anyMatch(actorName::equals));
        Assertions.assertTrue(actorsSql.stream().map(ActorSql::getName).anyMatch(actorName1::equals));
    }
}
