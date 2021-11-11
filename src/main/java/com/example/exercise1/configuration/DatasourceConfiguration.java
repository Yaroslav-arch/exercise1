package com.example.exercise1.configuration;

import com.example.exercise1.neo4j.MainServiceNeo4j;
import com.example.exercise1.sql.MainServiceSql;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
public class DatasourceConfiguration {

    @Configuration
    @ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "true")
//    @ComponentScan(basePackages = "com.example.exercise1",excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.exercise1\\.neo4j\\..*"))//TODO
        public static class SqlConfig {

        @Bean
        public MainServiceSql createSqlMainService(){
            return new MainServiceSql();
        }

    }

    @Configuration
    @ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "false", matchIfMissing = true)
//    @ComponentScan(basePackages = "com.example.exercise1", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.example\\.exercise1\\.neo4j\\..*"))//TODO
    public static class Neo4jConfig {

        @Bean
        public MainServiceNeo4j createNeo4jMainService(){
            return new MainServiceNeo4j();
        }
    }
}
