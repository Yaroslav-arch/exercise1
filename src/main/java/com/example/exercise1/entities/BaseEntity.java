package com.example.exercise1.entities;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

}
