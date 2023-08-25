package com.fpf.beerdispenser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BeerdispenserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerdispenserApplication.class, args);
    }

}
