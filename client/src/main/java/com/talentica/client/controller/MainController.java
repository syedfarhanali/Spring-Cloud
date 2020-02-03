package com.talentica.client.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {


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
}
