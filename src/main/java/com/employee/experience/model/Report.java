package com.employee.experience.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reports")
public class Report {

    @Id@GeneratedValue
    private Long id;

    @Column
    private String projectName;

    @Column
    private Long employeeId;

    @Column
    private Date reportDate;

    @Column
    private Experience experience;

    public Report() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }
}
