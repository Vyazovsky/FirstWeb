package com.viazovskyi.first_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class RootController {
    @GetMapping("swagger")
    public String getSwagger(){
        return "redirect:/swagger-ui.html";
    }

    public String home() {
        return "home";
    }
}
