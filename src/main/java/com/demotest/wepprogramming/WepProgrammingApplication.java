package com.demotest.wepprogramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WepProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WepProgrammingApplication.class, args);
    }

}
