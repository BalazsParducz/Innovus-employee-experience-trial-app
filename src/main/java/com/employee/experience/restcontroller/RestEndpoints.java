package com.employee.experience.restcontroller;


import org.springframework.web.bind.annotation.*;

@RestController
public class RestEndpoints {

    @GetMapping("/getReports/{projectName}/{userName}")
    public String getReportsOfProject(@RequestParam String projectName, @RequestParam String userName) {
        return userName + " " + projectName;
    }

}
