package com.kisonihc.spring.mvc_hibernate_aop.service;

import com.kisonihc.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id );

     public void deleteEmployee(int id);
}
