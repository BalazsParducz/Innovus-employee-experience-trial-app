package com.employee.experience.service;

import com.employee.experience.model.Employee;
import com.employee.experience.model.Experience;
import com.employee.experience.model.Report;

import java.util.List;

public interface ReportService {

    void saveTodaysReportOnProject(Long employeeId, String projectName, String todaysExperience);

    List<Report> getAllExperienceReportsSorted(Long employeeId);

    List<Report> getEmployeeExperienceReportsOnProject(Long employeeId, String projectName);
}
