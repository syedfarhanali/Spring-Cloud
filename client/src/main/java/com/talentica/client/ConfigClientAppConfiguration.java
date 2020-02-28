package com.talentica.client;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="client")
public class ConfigClientAppConfiguration {

    private String property;

    public void setProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
