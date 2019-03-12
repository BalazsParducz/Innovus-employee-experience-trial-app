package com.employee.experience.restcontroller;


import com.employee.experience.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestEndpoints {

    @Autowired
    ReportService reportService;

    @GetMapping("/getReports/{projectName}/{userName}")
    public String getReportsOfProject(@RequestParam String projectName, @RequestParam String userName) {
        return userName + " " + projectName;
    }


    @PostMapping("/saveReport")
    public ResponseEntity<Object> saveTodaysReport(@RequestParam Long employeeId, @RequestParam String projectName, @RequestParam String todaysExperience) {
        System.out.println("Facebook");
        reportService.saveTodaysReportOnProject(employeeId, projectName, todaysExperience);
        return new ResponseEntity<>("Your report has been saved successfully.", HttpStatus.OK);
    }

}
