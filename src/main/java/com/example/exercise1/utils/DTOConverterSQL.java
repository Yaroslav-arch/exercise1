package com.example.exercise1.utils;

import com.example.exercise1.dto.*;
import com.example.exercise1.sql.entitySql.*;
import org.springframework.stereotype.Component;

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
        return new MovieDTO(movieSql.getId(), movieSql.getName(), movieSql.getDuration());
    }

    public UserDTO fromUserToDTO(UserSql userSql){
        return new UserDTO(userSql.getId(), userSql.getNickname());
    }
}
