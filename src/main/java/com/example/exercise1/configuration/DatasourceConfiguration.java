package com.example.exercise1.configuration;

import com.example.exercise1.neo4j.MainServiceNeo4j;
import com.example.exercise1.sql.MainServiceSql;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfiguration {

    @Configuration
    @ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "true")

        public static class SqlConfig {

        @Bean
        public MainServiceSql createSqlMainService(){
            return new MainServiceSql();
        }

    }

    @Configuration
    @ConditionalOnProperty(prefix = "datasource", name = "rdbms", havingValue = "false", matchIfMissing = true)
    public static class Neo4jConfig {

        @Bean
        public MainServiceNeo4j createNeo4jMainService(){
            return new MainServiceNeo4j();
        }
    }
}
