package com.example.exercise1.sql.entitySql;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "director")
public class DirectorSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "director_name")
    private String name;

    @ManyToMany(mappedBy = "directors")
    private List<MovieSql> movies;

}
