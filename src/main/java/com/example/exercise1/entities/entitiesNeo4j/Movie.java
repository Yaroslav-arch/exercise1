package com.example.exercise1.entities.entitiesNeo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@Node
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int duration;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Actor> actors;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Director> directors;

    @Relationship(type = "RATED", direction = Relationship.Direction.INCOMING)
    private List<User> users;

    @Relationship(type = "IN_GENRE")
    private List<Genre> genres;
}
