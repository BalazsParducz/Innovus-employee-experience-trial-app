package com.employee.experience;

import com.employee.experience.model.Employee;
import com.employee.experience.model.Project;
import com.employee.experience.repository.EmployeeRepository;
import com.employee.experience.repository.ProjectRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ExperienceReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperienceReportApplication.class, args);
    }


    @Bean
    ApplicationRunner init(ProjectRepository projectRepo, EmployeeRepository employeeRepo) {
        return args -> {
            Stream.of("Big Project", "Small Project", "Interesting Project", "Change the world project", "Let's get drunk Project")
                    .forEach(projectName -> {
                Project project = new Project();
                project.setProjectName(projectName);
                projectRepo.save(project);
            });
            projectRepo.findAll().forEach(System.out::println);

            Stream.of("Tercsi", "Fercsi", "Kata", "Klára").forEach(name -> {
                Employee employee = new Employee();
                employee.setName(name);
                employee.setEmail(employee.getName() + "@innovus.he");
                employeeRepo.save(employee);
            });
            employeeRepo.findAll().forEach(System.out::println);
        };
    }
}
