package com.employee.experience.service;

import com.employee.experience.model.Employee;
import com.employee.experience.model.Experience;
import com.employee.experience.model.Project;

import java.util.List;

public interface ReportService {

    void saveTodaysReport(String todaysExperience, String project, Employee employee);

    List<Experience> getAllExperienceReports(Employee employee);

    List<Experience> getEmployeeExperienceReportsOnProject(Project project, Employee employee);
}
