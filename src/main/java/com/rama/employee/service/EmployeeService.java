package com.rama.employee.service;

import java.util.List;
import java.util.Optional;

import com.rama.employee.entity.Employee;

public interface EmployeeService {

	Optional<Employee> fetchEmployee(Integer empId);
	Employee saveEmployee(Employee employee);
	boolean deleteEmployee(Integer empId);
	List<Employee> fetchAllEmployees();
	List<Employee> fetctEmpSortByName();
	List<Employee> fetctEmpSortBySalary();
	
	
}
