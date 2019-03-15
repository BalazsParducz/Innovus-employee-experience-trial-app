package com.employee.experience.restcontroller;


import com.employee.experience.model.Employee;
import com.employee.experience.repository.EmployeeRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthEndpoints {

    private EmployeeRepository employeeRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthEndpoints(EmployeeRepository employeeRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public void registerNewEmployee(@RequestBody Employee newEmployee) {
        newEmployee.setPassword(bCryptPasswordEncoder.encode(newEmployee.getPassword()));
        employeeRepository.save(newEmployee);
    }
}
