package com.example.exercise1.neo4j.serviceNeo4j;

import com.example.exercise1.neo4j.entityNeo4j.UserNeo4j;
import com.example.exercise1.neo4j.repositoryNeo4j.UserRepositoryNeo4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceNeo4j {
    private final UserRepositoryNeo4j userRepositoryNeo4j;

    @Inject
    public UserServiceNeo4j(UserRepositoryNeo4j userRepositoryNeo4j) {
        this.userRepositoryNeo4j = userRepositoryNeo4j;
    }

    public List<UserNeo4j> getAllUsers() {
        return userRepositoryNeo4j.findAll();
    }

    public void saveUser(UserNeo4j user) {
        userRepositoryNeo4j.save(user);
    }
}
