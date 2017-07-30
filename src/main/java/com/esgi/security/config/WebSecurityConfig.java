package com.esgi.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${ldap.provider.url}")
    private String providerUrl;

    @Value("${ldap.provider.userdn}")
    private String providerUserDn;

    @Value("${ldap.provider.password}")
    private String providerPassword;

    @Value("${ldap.user.dn.patterns}")
    private String userDnPatterns;

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {

        httpSecurity
            .csrf().disable();
    }
}

/*
https://spring.io/guides/gs/authenticating-ldap/
https://auth0.com/blog/securing-spring-boot-with-jwts/
https://github.com/szerhusenBC/jwt-spring-security-demo/blob/master/src/main/java/org/zerhusen/config/WebSecurityConfig.java
https://github.com/SNCF-SIV/spring-security-rest-jwt-ldap/blob/master/src/main/java/com/sncf/siv/poc/security/config/WebSecurityConfiguration.java
 */