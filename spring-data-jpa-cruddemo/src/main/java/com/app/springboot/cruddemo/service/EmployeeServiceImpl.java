package com.app.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.springboot.cruddemo.dao.EmployeeRepository;
import com.app.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	//@Transactional -- remove bcz JPARepository provides this functionality
	public Employee findById(int theId) {
		//return employeeRepository.findById(theId);//rightclick -refactor - Extract Local Variable
		Optional<Employee> result= employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent())
		{
			theEmployee = result.get();
		}
		else
		{
			//we didnt find the employee
			throw new RuntimeException("Did not find employee id = "+theId);
		}
		
		return theEmployee;
	}

	@Override
	//@Transactional
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	//@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}






