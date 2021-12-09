package com.example.exercise1.sql.entitySql;

import lombok.Data;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "actor")
@Profile("postgres")
public class ActorSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actor_name")
    private String name;

    @ManyToMany(mappedBy = "actors")
    private List<MovieSql> movies;

    public ActorSql(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ActorSql() {
    }
}
