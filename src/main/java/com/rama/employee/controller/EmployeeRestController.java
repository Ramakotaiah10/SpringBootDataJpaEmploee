package com.rama.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rama.employee.entity.Employee;
import com.rama.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/vl")
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> EmployeefindById(@PathVariable("id") Integer empId) {

		Optional<Employee> EmployeeData = service.fetchEmployee(empId);

		System.out.println(EmployeeData);
		if (EmployeeData.isPresent()) {
			return new ResponseEntity<Employee>(EmployeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {

		try {
			Employee saveEmployee = service.saveEmployee(employee);
			return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") Integer empId, @RequestBody Employee employee) {

		Optional<Employee> empData = service.fetchEmployee(empId);
		if (empData.isPresent()) {
			Employee employee2 = empData.get();

			employee2.setEmpName(employee.getEmpName());
			employee2.setEmpSal(employee.getEmpSal());
			employee2.setEmpEmail(employee.getEmpEmail());
			employee2.setEmpExperience(employee.getEmpExperience());
			employee2.setEmpDesignation(employee.getEmpDesignation());
			return new ResponseEntity<Employee>(service.saveEmployee(employee2), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer empId) {

		boolean deletedEmp = service.deleteEmployee(empId);

		if (deletedEmp) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getEmployess")
	public ResponseEntity<?> FetchEMployeesData() {

	    List<Employee> fetchAllEmployees = service.fetchAllEmployees();

		System.out.println(fetchAllEmployees);
		if (fetchAllEmployees.isEmpty()) {
			return new ResponseEntity<String>("Records Not Found in Db",HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<Employee>>(fetchAllEmployees, HttpStatus.OK);
		}
	}

	@GetMapping("/getEmpmploeeSortByName")
	public ResponseEntity<?> getempdataSortByName() {

	    List<Employee> fetctEmpSortByName = service.fetctEmpSortByName();

		System.out.println(fetctEmpSortByName);
		if (fetctEmpSortByName.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Employee>>(fetctEmpSortByName, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getEmpmploeeSortBySalary")
	public ResponseEntity<?> getempdataSortBySalary() {
          
	    List<Employee> fetctEmpSortBySalary = service.fetctEmpSortBySalary();

		System.out.println(fetctEmpSortBySalary);
		if (fetctEmpSortBySalary.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Employee>>(fetctEmpSortBySalary, HttpStatus.OK);
		}
	}
}
