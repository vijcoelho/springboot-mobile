package com.api.springserver;

import com.api.springserver.model.employee.Employee;
import com.api.springserver.model.employee.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringserverApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;

//	@Test
//	void contextLoads() {
//		Employee employee = new Employee();
//		employee.setName("Wayne");
//		employee.setLocation("Building-X");
//		employee.setBranch("Batman");
//		employeeDao.save(employee);
//	}

//	@Test
//	void getAllEmployees() {
//		List<Employee> employees = employeeDao.getAllEmployee();
//		System.out.println(employees);
//	}
//
//	@Test
//	void deleteAllEmployees() {
//		List<Employee> employees = employeeDao.getAllEmployee();
//		for(Employee employee : employees) {
//			employeeDao.delete(employee);
//		}
//	}
}
