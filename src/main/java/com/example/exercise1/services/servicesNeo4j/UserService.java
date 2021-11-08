package com.example.exercise1.services.servicesNeo4j;

import com.example.exercise1.entities.entitiesNeo4j.User;
import com.example.exercise1.repositories.neo4jrepositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
