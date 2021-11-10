package com.example.exercise1.utils;

import com.example.exercise1.dto.*;
import com.example.exercise1.neo4j.entityNeo4j.*;
import org.springframework.stereotype.Component;

@Component
public class DTOConverterNeo4j {

    public ActorDTO fromActorToDTO(ActorNeo4j actorNeo4j){
        return new ActorDTO(actorNeo4j.getId(), actorNeo4j.getName());
    }

    public DirectorDTO fromDirectorToDTO(DirectorNeo4j directorNeo4j){
        return new DirectorDTO(directorNeo4j.getId(), directorNeo4j.getName());
    }

    public GenreDTO fromGenreToDTO(GenreNeo4j genreNeo4j){
        return new GenreDTO(genreNeo4j.getId(), genreNeo4j.getName());
    }

    public MovieDTO fromMovieToDTO(MovieNeo4j movieNeo4j){
        return new MovieDTO(movieNeo4j.getId(), movieNeo4j.getName(), movieNeo4j.getDuration());
    }

    public UserDTO fromUserToDTO(UserNeo4j userNeo4j){
        return new UserDTO(userNeo4j.getId(), userNeo4j.getNickname());
    }
}
