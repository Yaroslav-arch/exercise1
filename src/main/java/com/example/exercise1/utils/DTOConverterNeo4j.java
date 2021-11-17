package com.example.exercise1.utils;

import com.example.exercise1.dto.*;
import com.example.exercise1.neo4j.entityNeo4j.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DTOConverterNeo4j {

    public ActorDTO fromActorToDto(ActorNeo4j actorNeo4j) {
        return new ActorDTO(actorNeo4j.getId(), actorNeo4j.getName());
    }

    public DirectorDTO fromDirectorToDto(DirectorNeo4j directorNeo4j) {
        return new DirectorDTO(directorNeo4j.getId(), directorNeo4j.getName());
    }

    public GenreDTO fromGenreToDto(GenreNeo4j genreNeo4j) {
        return new GenreDTO(genreNeo4j.getId(), genreNeo4j.getName());
    }

    public MovieDTO fromMovieToDto(MovieNeo4j movieNeo4j) {
        return MovieDTO
                .builder()
                .id(movieNeo4j.getId())
                .name(movieNeo4j.getName())
                .actors(movieNeo4j
                        .getActors()
                        .stream()
                        .map(this::fromActorToDto)
                        .collect(Collectors.toList()))
                .directors(movieNeo4j
                        .getDirectors()
                        .stream()
                        .map(this::fromDirectorToDto)
                        .collect(Collectors.toList()))
                .genres(movieNeo4j
                        .getGenres()
                        .stream()
                        .map(this::fromGenreToDto)
                        .collect(Collectors.toList()))
                .users(movieNeo4j
                        .getUsers()
                        .stream()
                        .map(this::fromUserToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public UserDTO fromUserToDto(UserNeo4j userNeo4j) {
        return new UserDTO(userNeo4j.getId(), userNeo4j.getNickname());
    }

    public ActorNeo4j toActorFromDto(ActorDTO actorDTO) {
        return new ActorNeo4j(actorDTO.getId(), actorDTO.getName());
    }

    public DirectorNeo4j toDirectorFromDto(DirectorDTO directorDTO) {
        return new DirectorNeo4j(directorDTO.getId(), directorDTO.getName());
    }

    public GenreNeo4j toGenreFromDto(GenreDTO genreDTO) {
        return new GenreNeo4j(genreDTO.getId(), genreDTO.getName());
    }

    public MovieNeo4j toMovieFromDto(MovieDTO movieDTO) {
        return MovieNeo4j
                .builder()
                .id(movieDTO.getId())
                .name(movieDTO.getName())
                .actors(movieDTO.getActors()
                        .stream()
                        .map(this::toActorFromDto)
                        .collect(Collectors.toList()))
                .directors(movieDTO.getDirectors()
                        .stream()
                        .map(this::toDirectorFromDto)
                        .collect(Collectors.toList()))
                .genres(movieDTO.getGenres()
                        .stream()
                        .map(this::toGenreFromDto)
                        .collect(Collectors.toList()))
                .users(movieDTO.getUsers()
                        .stream()
                        .map(this::toUserFromDto).collect(Collectors.toList()))
                .build();
    }

    public UserNeo4j toUserFromDto(UserDTO userDTO) {
        return new UserNeo4j(userDTO.getId(), userDTO.getNickname());
    }
}
