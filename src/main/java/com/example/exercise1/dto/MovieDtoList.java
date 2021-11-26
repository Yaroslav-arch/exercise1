package com.example.exercise1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MovieDtoList {
    private List<MovieDTO> movies;
}
