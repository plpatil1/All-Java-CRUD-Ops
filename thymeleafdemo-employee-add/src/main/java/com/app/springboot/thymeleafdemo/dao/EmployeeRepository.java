package com.app.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.springboot.thymeleafdemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
