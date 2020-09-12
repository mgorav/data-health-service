package com.gonnect.datalineage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableTransactionManagement
public class DataHealthServiceApplication implements ApplicationRunner {
    @Autowired
    private DataSimulator simulator;

    public static void main(String[] args) {
        SpringApplication.run(DataHealthServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        simulator.simulate();
    }
}
