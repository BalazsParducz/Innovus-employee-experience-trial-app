package com.employee.experience.repository;

import com.employee.experience.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByEmployeeIdAndProjectName(Long employeeId, String projectName);

    List<Report> findAllByEmployeeId(Long employeeId);
}
