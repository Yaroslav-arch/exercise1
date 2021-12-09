package com.example.exercise1.sql.entitySql;

import lombok.Data;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "genre")
@Profile("postgres")
public class GenreSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "movies_of_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<MovieSql> movies;

    public GenreSql(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreSql() {
    }
}
