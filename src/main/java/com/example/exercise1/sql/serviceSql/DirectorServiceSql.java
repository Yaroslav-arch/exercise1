package com.example.exercise1.sql.serviceSql;

import com.example.exercise1.sql.entitySql.DirectorSql;
import com.example.exercise1.sql.repositorySql.DirectorRepositorySql;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class DirectorServiceSql {
    private final DirectorRepositorySql directorRepositorySql;

    @Inject
    public DirectorServiceSql(DirectorRepositorySql directorRepositorySql) {
        this.directorRepositorySql = directorRepositorySql;
    }

    public List<DirectorSql> getAllDirectors() {
        return directorRepositorySql.findAll();
    }

    public void saveDirector(DirectorSql director) {
        directorRepositorySql.save(director);
    }
}
