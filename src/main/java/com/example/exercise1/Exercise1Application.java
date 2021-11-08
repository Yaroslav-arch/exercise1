package com.example.exercise1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableNeo4jRepositories
@SpringBootApplication
public class Exercise1Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise1Application.class, args);
	}

}
