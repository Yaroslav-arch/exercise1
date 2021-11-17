package com.example.exercise1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    private String name;
    private int duration;
    private List<ActorDTO> actors;
    private List<DirectorDTO> directors;
    private List<GenreDTO> genres;
    private List<UserDTO> users;
}
