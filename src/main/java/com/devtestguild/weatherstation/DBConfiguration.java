package com.devtestguild.weatherstation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection(){
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection for DEV - H2";
    }

    @Profile("prd")
    public String prdDatabaseConnection(){
        System.out.println("DB Connection to PostgreSQL PRD");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to PRD - PostgreSQL";
    }
}
