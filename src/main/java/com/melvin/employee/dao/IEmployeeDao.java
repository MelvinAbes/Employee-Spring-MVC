package com.melvin.employee.dao;

import java.util.List;

import com.melvin.employee.entity.Employee;

public interface IEmployeeDao {
	
	List<Employee> getAllEmployees(); 
	
	Boolean addAnEmployee(Employee employee);
	
	Employee getEmployee(int id);

	Boolean updateAnEmployee(Employee employee);

	Boolean deleteAnEmployee(int id);

}
