package com.employee.experience.service;

import com.employee.experience.model.Employee;
import com.employee.experience.model.Experience;
import com.employee.experience.model.Project;
import com.employee.experience.model.Report;
import com.employee.experience.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Comparator;
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
    public List<Report> getAllExperienceReportsSorted(Long employeeId) {
        List<Report> reports = reportRepository.findAllByEmployeeId(employeeId);
        reports.sort(Comparator.comparing(Report :: getReportDate).reversed().thenComparing(Report :: getProjectName));
        return reports;
    }

    @Override
    public List<Report> getEmployeeExperienceReportsOnProject(Long employeeId, String projectName) {
        return reportRepository.findAllByEmployeeIdAndProjectName(employeeId, projectName);
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
