package com.rama.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;

import com.rama.employee.entity.Employee;
import com.rama.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Optional<Employee> fetchEmployee(Integer empId) {
		return repo.findById(empId);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		 return repo.save(employee);
	}

	@Override
	public boolean deleteEmployee(Integer empId) {
       
		try {
			 repo.deleteById(empId);
		      return true;
		    } catch (Exception e) {
		    	return false;
		    }
	}

	public List<Employee> fetchAllEmployees() {
		 return repo.findAll();
		
	}

	@Override
	public List<Employee> fetctEmpSortByName() {
		 return repo.findAll(Sort.by("empName"));
	}
	@Override
	public List<Employee> fetctEmpSortBySalary() {
		 return repo.findAll(Sort.by("empSal"));
	}
	
}
