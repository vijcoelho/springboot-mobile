package com.api.springserver.controllers;

import com.api.springserver.model.employee.Employee;
import com.api.springserver.model.employee.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee/get-all")
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployee();
    }

    @PostMapping("/employee/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeDao.save(employee);
    }
}
