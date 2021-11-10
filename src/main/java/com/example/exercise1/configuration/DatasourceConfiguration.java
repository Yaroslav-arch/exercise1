package com.example.exercise1.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
public class DatasourceConfiguration {

    @Configuration
    @ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "true")
    @ComponentScan(basePackages = "com.example.exercise1",excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.exercise1\\.neo4j\\..*"))//TODO
        public static class SqlConfig {

    }

    @Configuration
    @ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "false", matchIfMissing = true)
    @ComponentScan(basePackages = "com.example.exercise1", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.exercise1\\.neo4j\\..*"))//TODO
    public static class Neo4jConfig {

    }
}
