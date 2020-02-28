package com.talentica.client.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.talentica.client.ConfigClientAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class MainController {

    @Autowired
    ConfigClientAppConfiguration properties;


    @Value("${client.other.property}")
    private String someOtherProperty;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @RequestMapping("/")
    public String main(){

        RestTemplate restTemplate = restTemplateBuilder.build();

        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service",false);

        String baseUrl = instanceInfo.getHomePageUrl();

        ResponseEntity<String> responseEntity =  restTemplate.exchange(baseUrl, HttpMethod.GET, null,String.class);

        return responseEntity.toString();
    }

    @RequestMapping("/properties")
    public String properties(){

        return someOtherProperty;
    }
}
