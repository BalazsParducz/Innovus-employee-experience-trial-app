package com.employee.experience.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Endpoints {


    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

}
