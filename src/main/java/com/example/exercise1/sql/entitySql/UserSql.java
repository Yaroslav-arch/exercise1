package com.example.exercise1.sql.entitySql;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class UserSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @ManyToMany(mappedBy = "users")
    private List<MovieSql> movies;
}
