package com.eg.sysmanage.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigRest {

    @Bean
    @LoadBalanced // 客户端 负载均衡，增加这一个配置即可
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
