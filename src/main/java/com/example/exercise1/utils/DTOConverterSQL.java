package com.example.exercise1.utils;

import com.example.exercise1.dto.*;
import com.example.exercise1.sql.entitySql.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DTOConverterSQL {

    public ActorDTO fromActorToDTO(ActorSql actorSql){
        return new ActorDTO(actorSql.getId(), actorSql.getName());
    }

    public DirectorDTO fromDirectorToDTO(DirectorSql directorSql){
        return new DirectorDTO(directorSql.getId(), directorSql.getName());
    }

    public GenreDTO fromGenreToDTO(GenreSql genreSql){
        return new GenreDTO(genreSql.getId(), genreSql.getName());
    }

    public MovieDTO fromMovieToDTO(MovieSql movieSql){
        return MovieDTO
                .builder()
                .id(movieSql.getId())
                .name(movieSql.getName())
                .actors(movieSql
                        .getActors()
                        .stream()
                        .map(this::fromActorToDTO)
                        .collect(Collectors.toList()))
                .directors(movieSql
                        .getDirectors()
                        .stream()
                        .map(this::fromDirectorToDTO)
                        .collect(Collectors.toList()))
                .genres(movieSql
                        .getGenres()
                        .stream()
                        .map(this::fromGenreToDTO)
                        .collect(Collectors.toList()))
                .users(movieSql
                        .getUsers()
                        .stream()
                        .map(this::fromUserToDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public UserDTO fromUserToDTO(UserSql userSql){
        return new UserDTO(userSql.getId(), userSql.getNickname());
    }

    public ActorSql toActorFromDto(ActorDTO actorDTO) {
        return new ActorSql(actorDTO.getId(), actorDTO.getName());
    }

    public DirectorSql toDirectorFromDto(DirectorDTO directorDTO) {
        return new DirectorSql(directorDTO.getId(), directorDTO.getName());
    }

    public GenreSql toGenreFromDto(GenreDTO genreDTO) {
        return new GenreSql(genreDTO.getId(), genreDTO.getName());
    }

    public MovieSql toMovieFromDto(MovieDTO movieDTO) {
        return MovieSql
                .builder()
                .id(movieDTO.getId())
                .name(movieDTO.getName())
                .duration(movieDTO.getDuration())
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
                        .map(this::toUserFromDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public UserSql toUserFromDto(UserDTO userDTO) {
        return new UserSql(userDTO.getId(), userDTO.getNickname());
    }
}
