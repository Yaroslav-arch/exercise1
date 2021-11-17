package com.example.exercise1.sql.serviceSql;

import com.example.exercise1.sql.entitySql.UserSql;
import com.example.exercise1.sql.repositorySql.UserRepositorySql;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceSql {

    private final UserRepositorySql userRepositorySql;

    @Inject
    public UserServiceSql(UserRepositorySql userRepositorySql) {
        this.userRepositorySql = userRepositorySql;
    }

    public List<UserSql> getAllUsers() {
        return userRepositorySql.findAll();
    }

    public void saveUser(UserSql user) {
        userRepositorySql.save(user);
    }
}
