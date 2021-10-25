//package com.example.exercise1;
//
//import org.neo4j.driver.Driver;
//import org.neo4j.ogm.session.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
//import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
//
//@Configuration
//@ComponentScan("com.example.demo")
//@EnableNeo4jRepositories(
//        basePackages = "com.example.demo.repository")
//public class Neo4jConfigurationNone {
//    public static final String URL =
//            System.getenv("NEO4J_URL") != null ?
//                    System.getenv("NEO4J_URL") : "bolt://localhost:7687";
//
//    @Bean
//    public org.neo4j.ogm.config.Configuration getConfiguration() {
//        return new org.neo4j.ogm.config.Configuration.Builder().uri(URL).build();
//    }
//
//    @Bean
//    public SessionFactory getSessionFactory() {
//        return new SessionFactory(getConfiguration(),
//                "com.example.demo.entities");
//    }
//
//    @Bean
//    public Neo4jTransactionManager transactionManager() {
//        return new Neo4jTransactionManager((Driver) getSessionFactory());
//    }
//}
