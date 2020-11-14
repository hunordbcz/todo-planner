package com.se.debreczeni;

import com.se.debreczeni.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.se.debreczeni.controller.repository")
@EntityScan("com.se.debreczeni.model")
@SpringBootApplication
public class SeMiniProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeMiniProjectApplication.class, args);
    }

}
