package com.example.exercise1.neo4j.entityNeo4j;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node(labels = "Genre")
public class GenreNeo4j {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
