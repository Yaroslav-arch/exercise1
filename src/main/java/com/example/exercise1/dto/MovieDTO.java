package com.example.exercise1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class MovieDTO {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int duration;
    @NotNull
    private List<ActorDTO> actors;
    @NotNull
    private List<DirectorDTO> directors;
    @NotNull
    private List<GenreDTO> genres;
    @NotNull
    private List<UserDTO> users;
}
