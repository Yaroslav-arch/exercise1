package com.example.exercise1.services.servicesSQL;

import com.example.exercise1.entities.entitiesSQL.User;
import com.example.exercise1.repositories.sqlRepositories.UserRepository;
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
