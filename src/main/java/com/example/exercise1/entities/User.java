package com.example.exercise1.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Data
@Node
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;

    @Relationship(type = "RATED")
    private Set<Movie> movies;
}
