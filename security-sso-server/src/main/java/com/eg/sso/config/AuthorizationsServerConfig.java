//package com.eg.sso.config;
//
//import com.eg.sso.service.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//@Configuration
//public class AuthorizationsServerConfig extends AuthorizationServerConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private JwtAccessTokenConverter jwtAccessTokenConverter;
//    @Autowired
//    CustomUserDetailsService userDetailService;
//    @Autowired
//    public AuthenticationManager authenticationManager;
//
//    @Bean("keyprop")
//    public KeyProperties keyProperties(){
//        return new KeyProperties();
//    }
//    @Resource(name="keyprop")
//    private KeyProperties keyProperties;
//
//    // 客户端配置
//    @Bean
//    public ClientDetailsService clientDetailsService(){
//        return new JdbcClientDetailsService(dataSource);
//    }
//
//}
