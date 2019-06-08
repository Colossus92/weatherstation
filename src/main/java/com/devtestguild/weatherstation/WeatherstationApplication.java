package com.devtestguild.weatherstation;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class WeatherstationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherstationApplication.class, args);
    }

}
