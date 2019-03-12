package com.employee.experience.service;

import com.employee.experience.model.Employee;
import com.employee.experience.model.Experience;
import com.employee.experience.model.Project;

import java.util.List;

public interface ReportService {

    void saveTodaysReportOnProject(Long employeeId, String projectName, String todaysExperience);

    List<Experience> getAllExperienceReports(Employee employee);

    List<Experience> getEmployeeExperienceReportsOnProject(Project project, Employee employee);
}
