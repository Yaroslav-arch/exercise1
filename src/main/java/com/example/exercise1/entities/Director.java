package com.example.exercise1.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Data
@Node
public class Director {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Relationship(type = "DIRECTED")
    private Set<Movie> movies;
}
