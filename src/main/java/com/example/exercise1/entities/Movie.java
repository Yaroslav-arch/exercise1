package com.example.exercise1.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Data
@Node
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int duration;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private Set<Actor> actors;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private Set<Director> directors;

    @Relationship(type = "RATED", direction = Relationship.Direction.INCOMING)
    private Set<User> users;

    @Relationship(type = "IN_GENRE")
    private Set<Genre> genres;
}
