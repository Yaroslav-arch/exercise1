package com.example.exercise1.sql.repository;

import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.repositorySql.ActorRepositorySql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.inject.Inject;
import java.util.List;

@SpringBootTest
@ActiveProfiles("postgres")
public class ActorRepositorySqlTest {

    @Inject
    private ActorRepositorySql actorRepositorySql;

    @Test
    public void getAllActorsByMovieNameTest() {
        String movieName = "Matrix";
        String actorName = "Keanu Reeves";
        String actorName1 = "Hugo Weaving";
        List<ActorSql> actorsSql = actorRepositorySql.getByMovies_Name(movieName);

        Assertions.assertEquals(2, actorsSql.size());
        Assertions.assertEquals(actorName, actorsSql.get(0).getName());
        Assertions.assertTrue(actorsSql.stream().map(ActorSql::getName).anyMatch(actorName::equals));
        Assertions.assertTrue(actorsSql.stream().map(ActorSql::getName).anyMatch(actorName1::equals));
    }
}
