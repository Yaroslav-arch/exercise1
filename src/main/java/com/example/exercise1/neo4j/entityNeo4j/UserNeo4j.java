package com.example.exercise1.neo4j.entityNeo4j;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node(labels = "User")
@Profile("neo4j")
public class UserNeo4j {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;

    public UserNeo4j(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
