package com.resume.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
class HomeController {

    @GetMapping("/")
    public String main(String[] args) {
        return "Hello World!";
    }

}
