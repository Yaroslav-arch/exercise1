package com.example.exercise1.neo4j.entityNeo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@Node(labels = "Movie")
public class MovieNeo4j {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int duration;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<ActorNeo4j> actors;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<DirectorNeo4j> directors;

    @Relationship(type = "RATED", direction = Relationship.Direction.INCOMING)
    private List<UserNeo4j> users;

    @Relationship(type = "IN_GENRE")
    private List<GenreNeo4j> genres;
}
