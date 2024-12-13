package com.kicc.home.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/*")
public class MainController {

    @RequestMapping("/main")
    public String main() {
        return "main/main";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
