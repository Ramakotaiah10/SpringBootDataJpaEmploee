package com.rama.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rama.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
