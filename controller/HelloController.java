package com.myproject.my_Domy_project.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/hello")
    public String helloApi(){
        return "hello coder!!!";
    }
}
