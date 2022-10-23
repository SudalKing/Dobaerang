package com.jmcompany.dobaerang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DobaerangApplication {

    public static void main(String[] args) {
        SpringApplication.run(DobaerangApplication.class, args);
    }

}
