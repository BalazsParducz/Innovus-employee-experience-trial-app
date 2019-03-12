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

    @GetMapping("/getReportsOnProject/{employeeId}/{projectName}")
    public ResponseEntity<Object> getReportsOfProject(@RequestParam Long employeeId, @RequestParam String projectName) {
        return new ResponseEntity<Object>(reportService.getEmployeeExperienceReportsOnProject(employeeId, projectName), HttpStatus.OK);
    }

    @PostMapping("/saveReport")
    public ResponseEntity<Object> saveTodaysReport(@RequestParam Long employeeId, @RequestParam String projectName, @RequestParam String todaysExperience) {
        reportService.saveTodaysReportOnProject(employeeId, projectName, todaysExperience);
        return new ResponseEntity<>("Your report has been saved successfully.", HttpStatus.OK);
    }

}
