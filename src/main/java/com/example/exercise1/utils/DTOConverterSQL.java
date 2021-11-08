package com.example.exercise1.utils;

import com.example.exercise1.entities.dto.*;
import com.example.exercise1.entities.entitiesSQL.*;
import org.springframework.stereotype.Component;

@Component
public class DTOConverterSQL {

    public ActorDTO fromActorToDTO(Actor actor){
        return new ActorDTO(actor.getName());
    }

    public DirectorDTO fromDirectorToDTO(Director director){
        return new DirectorDTO(director.getName());
    }

    public GenreDTO fromGenreToDTO(Genre genre){
        return new GenreDTO(genre.getName());
    }

    public MovieDTO fromMovieToDTO(Movie movie){
        return new MovieDTO(movie.getName(),movie.getDuration());
    }

    public UserDTO fromUserToDTO(User user){
        return new UserDTO(user.getNickname());
    }
}
