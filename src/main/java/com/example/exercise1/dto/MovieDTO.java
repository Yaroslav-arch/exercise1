package com.example.exercise1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    private String name;
    private int duration;
}
