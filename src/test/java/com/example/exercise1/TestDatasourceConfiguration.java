package com.example.exercise1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestDatasourceConfiguration {

    @Configuration
    @Profile("postgres")
    @ComponentScan(
            basePackages = "com.example.exercise1",
            excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.exercise1\\.neo4j\\..*")
    )
    public static class SqlConfig {

    }

    @Configuration
    @Profile("neo4j")
    @ComponentScan(
            basePackages = "com.example.exercise1",
            excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.exercise1\\.sql\\..*")
    )
    public static class Neo4jConfig {

    }
}
