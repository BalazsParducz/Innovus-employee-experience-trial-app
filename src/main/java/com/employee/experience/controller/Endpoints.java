package com.employee.experience.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Endpoints {


    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @PostMapping("/saveExperience/{userId}/{mood}")
    public String saveExperience(@RequestParam String userId, @RequestParam String mood) {
        return userId + " " + mood;
    }
}
