package com.example.exercise1.sql.entitySql;

import lombok.Data;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "director")
@Profile("postgres")
public class DirectorSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "director_name")
    private String name;

    @ManyToMany(mappedBy = "directors")
    private List<MovieSql> movies;

    public DirectorSql(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DirectorSql() {
    }
}
