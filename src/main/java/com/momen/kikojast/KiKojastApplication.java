package com.momen.kikojast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KiKojastApplication {

    public static void main(String[] args) {
        SpringApplication.run(KiKojastApplication.class, args);
    }

}
