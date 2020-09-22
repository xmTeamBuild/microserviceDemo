package com.eg.sso.config;

import com.eg.sso.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class webSecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String FORM_BASED_LOGIN_ENTRY_POINT = "/login";
    public static final String LOGIN_ERROR_POINT = "/error";
    public static final String TOKEN_REFRESH_ENTRY_POINT = "/oauth/token";

//    @Autowired
//    OrderedCharacterEncodingFilter charsetFilter;

    @Autowired
    CustomUserDetailsService customUserDetailsService ;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 不能禁用session
        http.antMatcher("/**")
//                .addFilterBefore(charsetFilter, CsrfFilter.class)
                // 使用自定义用户服务
                .userDetailsService(customUserDetailsService)
                // 跨域
                .cors()
                // support cross domain
                .and()
                // diable crsf
//                .csrf().disable().formLogin().loginPage(FORM_BASED_LOGIN_ENTRY_POINT)
                //登录成功与失败的处理器
//                .failureHandler(loginFailureHandler).successHandler(loginSuccessSSOHandler).permitAll()
                // token
//                .and()
                // login请求放过
                .authorizeRequests().antMatchers(FORM_BASED_LOGIN_ENTRY_POINT, LOGIN_ERROR_POINT).permitAll() // Login
                // 获取token请求放过 // end-point
                .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll()
                .antMatchers("/**/*.js/**").permitAll()
                .antMatchers("/**/*.css/**").permitAll()
                .antMatchers("/**/*.jpg/**", "/**/*.png/**", "/**/*.ico/**").permitAll()
                .antMatchers("/**/validate/**").permitAll()
                .antMatchers("/**/userInfo/**").permitAll()
                .antMatchers("/**/*.html/**").permitAll()
                .antMatchers("/**/changePwd/**").permitAll()
                .antMatchers("/**/access/**").permitAll()
                // 新的
                .and()
                // 不允许ajax请求
                .httpBasic().disable()
                // 所有请求都必须认证过
                .authorizeRequests().anyRequest().authenticated();
                // 退出请求
//                .and()
                // AuthenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
//                .exceptionHandling().authenticationEntryPoint(entryPoint())
//                .and()
//                // 退出成功后
//                .logout().clearAuthentication(true).invalidateHttpSession(true)
//                .logoutSuccessHandler(customLogoutSuccessHandler).permitAll();
//        http.sessionManagement().maximumSessions(100).maxSessionsPreventsLogin(false)
//                .expiredUrl(FORM_BASED_LOGIN_ENTRY_POINT).sessionRegistry(sessionRegistry());
        //http.exceptionHandling().accessDeniedHandler(new LoginAccessDeniedHandler());
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        // allow options methods
        web.ignoring().antMatchers(HttpMethod.OPTIONS);
    }
    
}
