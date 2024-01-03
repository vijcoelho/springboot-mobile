package com.api.SpringServer;

import com.api.SpringServer.model.employee.Employee;
import com.api.SpringServer.model.employee.EmployeeDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Test
	void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setName("James");
		employee.setBranch("TI");
		employee.setLocation("Building-5");
		employeeDAO.save(employee);
	}

	@Test
	void getAllEmployees() {
		List<Employee> employees = employeeDAO.getAllEmployees();
		System.out.println(employees);
	}

//	@Test
	void getAllEmployeesAndDelete() {
		List<Employee> employees = employeeDAO.getAllEmployees();
		for (Employee employee: employees) {
			employeeDAO.delete(employee);
		}
	}
}
