package com.example.exercise1.sql.service;

import com.example.exercise1.sql.MainServiceSql;
import com.example.exercise1.sql.entitySql.ActorSql;
import com.example.exercise1.sql.repositorySql.ActorRepositorySql;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("postgres")
public class ActorServiceSqlTest {

    @Inject
    private MainServiceSql mainService;

    @MockBean
    private static ActorRepositorySql actorRepositorySql;

    @Before
    public void setUp() {
        ActorSql actor = new ActorSql(1L, "Mel Gibson");
        List<ActorSql> actors = new ArrayList<>();
        actors.add(actor);


        Mockito.when(actorRepositorySql.getByMovies_Name("Mad Max"))
                .thenReturn(actors);
    }

    @Test
    public void getAllActorsByMovieName() {
        String movieName = "Mad Max";
        Assertions.assertNotNull(mainService.getAllActorsByMovieName(movieName));
    }

}
