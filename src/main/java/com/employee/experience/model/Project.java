package com.employee.experience.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    public Project() {}

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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
