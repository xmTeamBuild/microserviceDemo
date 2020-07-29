package com.eg.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PaEurekaCenter03Application {

    public static void main(String[] args) {
        SpringApplication.run(PaEurekaCenter03Application.class, args);
    }

}
