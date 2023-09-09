package com.kusithm.partstudybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PartstudyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartstudyBackendApplication.class, args);
    }

}
