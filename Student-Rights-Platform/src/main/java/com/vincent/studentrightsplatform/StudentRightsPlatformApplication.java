package com.vincent.studentrightsplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class StudentRightsPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentRightsPlatformApplication.class, args);
    }

}
