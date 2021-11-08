package com.example.exercise1.services;

import com.example.exercise1.entities.entitiesNeo4j.Actor;
import com.example.exercise1.entities.entitiesNeo4j.Genre;
import com.example.exercise1.entities.entitiesNeo4j.Movie;
import com.example.exercise1.repositories.neo4jrepositories.ActorRepository;
import com.example.exercise1.services.servicesNeo4j.ActorService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ActorServiceTest {

    @Inject
    private ActorService actorService;

    @MockBean
    private static ActorRepository actorRepository;

    @Before
    public void setUp() {
        Actor actor = new Actor();
        actor.setName("Mel Gibson");
        List<Actor> actorList = new ArrayList<>();
        actorList.add(actor);
        Genre genre = new Genre();
        genre.setName("Action");
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);
        Movie movie1 = new Movie();
        movie1.setName("Mad Max");
        movie1.setActors(actorList);
        movie1.setGenres(genres);
        Movie movie2 = new Movie();
        movie2.setName("Lethal weapon");
        movie2.setActors(actorList);
        movie2.setGenres(genres);

        Mockito.when(actorRepository.getAllActorsByMovieName("Mad Max"))
                .thenReturn(actorList);
    }

    @Test
    public void getAllActorsByMovieName() {
        String movieName = "Mad Max";
        Assertions.assertNotNull(actorService.getAllActorsByMovieName(movieName));
    }

}
