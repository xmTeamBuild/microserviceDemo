package com.eg.sysmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进eureka服务中
@MapperScan("com.eg.sysmanage.dao")
@EnableDiscoveryClient
public class PaSysmanageCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaSysmanageCenterApplication.class, args);
    }

}
