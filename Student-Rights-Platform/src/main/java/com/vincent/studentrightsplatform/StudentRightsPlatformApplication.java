package com.vincent.studentrightsplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.info.BuildProperties;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class StudentRightsPlatformApplication {
    public static void main(String[] args) {
        Version a = new Version();
        System.out.println(Utilities.getDateAndTime(System.currentTimeMillis()) + "\n华南农业大学学生权益平台后端\n版本: " + a.getAppVersion());
        SpringApplication.run(StudentRightsPlatformApplication.class, args);
    }

}