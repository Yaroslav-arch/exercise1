package com.example.exercise1;

import com.example.exercise1.configuration.DatasourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = DatasourceConfiguration.class)
public class Exercise1Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise1Application.class, args);
    }


}
