package com.app.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
