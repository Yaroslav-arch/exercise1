package com.example.exercise1.sql.entitySql;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class MovieSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @ManyToMany
    @JoinTable(
            name = "acted_in",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<ActorSql> actors;

    @ManyToMany
    @JoinTable(
            name = "directed_by",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<DirectorSql> directors;

    @ManyToMany
    @JoinTable(
            name = "users_liked",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserSql> users;

    @ManyToMany(mappedBy = "movies")
    private List<GenreSql> genres;


}
