package com.talentica.service.controller;


import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping()
    public String message(@RequestHeader("x-location") String location){
        return "Hello from Service " + location;
    }


}
