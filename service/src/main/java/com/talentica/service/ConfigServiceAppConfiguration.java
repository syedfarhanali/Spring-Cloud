package com.talentica.service;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service")
public class ConfigServiceAppConfiguration {


    private String property;
    private String otherProperty;
    private String property1;
    private String property2;


    public String getProperty() {
        return property;
    }

    public String getOtherProperty() {
        return otherProperty;
    }

    public String getProperty1() {
        return property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setOtherProperty(String otherProperty) {
        this.otherProperty = otherProperty;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }


}
