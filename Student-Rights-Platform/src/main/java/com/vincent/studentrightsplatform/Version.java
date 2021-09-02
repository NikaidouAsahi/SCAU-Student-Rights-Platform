package com.vincent.studentrightsplatform;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

import java.util.Properties;


public class Version {
    @ConditionalOnMissingBean
    @Bean
    public BuildProperties buildProperties() {
        Properties properties = new Properties();
        properties.put("version", "21w35a-SNAPSHOT");
        return new BuildProperties(properties);
    }

    private String appVersion = buildProperties().getVersion();

    public String getAppVersion() {
        return appVersion;
    }

}
