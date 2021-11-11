package com.example.exercise1.sql.repository;

import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.repositorySql.ActorRepositorySql;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.TestPropertySource;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.List;

//@SpringBootTest
@DataJpaTest
@TestPropertySource("/application.properties")
public class ActorRepositorySqlTest {

    @Inject
    private ActorRepositorySql actorRepositorySql;

//    @Inject
//    private DataSource dataSource;
//
//    @Before
//    public void loadData() {
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("data.sql"));
//        resourceDatabasePopulator.execute(dataSource);
//    }


    @Test
    public void getAllActorsByMovieNameTest() {
        String movieName = "John Wick";
        String actorName = "Keanu Reeves";
        List<ActorSql> actorsSql = actorRepositorySql.getAllActorsByMovieName(movieName);

        Assertions.assertEquals(1, actorsSql.size());
        Assertions.assertEquals(actorName, actorsSql.get(0).getName());
    }
}
