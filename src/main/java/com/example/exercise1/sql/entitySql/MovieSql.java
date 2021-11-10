package com.example.exercise1.sql.entitySql;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "Movies")
public class MovieSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int duration;

    @ManyToMany
    private List<ActorSql> actorEntities;

    @ManyToMany
    private List<DirectorSql> directorEntities;

    @ManyToMany
    private List<UserSql> userEntities;

}
