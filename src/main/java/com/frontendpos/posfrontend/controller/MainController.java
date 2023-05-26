package com.frontendpos.posfrontend.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
