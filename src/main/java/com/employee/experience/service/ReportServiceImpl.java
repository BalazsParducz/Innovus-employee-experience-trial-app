package com.employee.experience.service;

import com.employee.experience.model.Employee;
import com.employee.experience.model.Experience;
import com.employee.experience.model.Project;
import com.employee.experience.model.Report;
import com.employee.experience.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Override
    public void saveTodaysReportOnProject(Long employeeId, String projectName, String todaysExperience) {
        final Report newReport = new Report();
        newReport.setEmployeeId(employeeId);
        newReport.setProjectName(projectName);
        newReport.setExperience(getExperienceEnum(todaysExperience));
        newReport.setReportDate(getReportDate());
        reportRepository.save(newReport);
    }

    @Override
    public List<Experience> getAllExperienceReports(Employee employee) {
        return null;
    }

    @Override
    public List<Experience> getEmployeeExperienceReportsOnProject(Project project, Employee employee) {
        return null;
    }


    private Experience getExperienceEnum(String employeeExperienceToday) {
        switch(employeeExperienceToday) {
            case "good":
                return Experience.GOOD;
            case "neutral":
                return Experience.NEUTRAL;
            case "bad":
                return Experience.BAD;
        }
        return null;
    }

    private Date getReportDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);
        return calendar.getTime();
    }
}
