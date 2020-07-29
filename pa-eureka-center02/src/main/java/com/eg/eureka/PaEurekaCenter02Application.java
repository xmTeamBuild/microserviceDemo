package com.eg.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PaEurekaCenter02Application {

    public static void main(String[] args) {
        SpringApplication.run(PaEurekaCenter02Application.class, args);
    }

}
