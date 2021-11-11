package com.example.exercise1.sql.entitySql;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Directors")
public class DirectorSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_id")
    private String name;

    @ManyToMany(mappedBy = "directors")
    private List<MovieSql> movies;

}
