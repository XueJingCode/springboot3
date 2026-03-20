package com.example.testspringboot_maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // ← 相当于 @Controller + @ResponseBody
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "Hello World!";
    }
}
