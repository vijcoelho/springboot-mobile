package com.api.SpringServer.controllers;

import com.api.SpringServer.model.employee.Employee;
import com.api.SpringServer.model.employee.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/employee/get-all")
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
