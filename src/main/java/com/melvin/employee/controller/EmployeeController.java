package com.melvin.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.melvin.employee.dao.IEmployeeDao;
import com.melvin.employee.entity.Employee;

//to perform crud operations on the employee system
@Controller

public class EmployeeController {

	@Autowired
	private IEmployeeDao employeeDao;	

	@RequestMapping(value = "/employee")
	private String getSingleEmployee(@RequestParam int id, Model theModel) {

		// call dao method to get a single employee
		Employee employee = employeeDao.getEmployee(id);
		theModel.addAttribute("employee", employee);
		return "employee-update";

	}

	//landing page controller method
	@RequestMapping()
	public String getAllEmployees(Model theModel) {

		//logging for debug purposes
		System.out.println("In employee controller getAllEmployees method");

		// call DAO method to get all employees, getAllEmployees()
		List<Employee> employees = employeeDao.getAllEmployees();

		// sysout the obtained list
		System.out.println("controller list of employees is " + employees);

		// pass list of employees to JSP page
		theModel.addAttribute("employees", employees);

		return "list-employees";

	}

	//to show form
	@RequestMapping(value = "/employee-add-form")
	public String showAddEmployeeForm(Model theModel) {

		theModel.addAttribute("employee", new Employee());

		return "employee-add";
	}

	//to add employee
	@RequestMapping(value = "/addEmployee")
	public String addAnEmployee(@ModelAttribute("employee") Employee employee) {

		// call DAO method
		employeeDao.addAnEmployee(employee);

		//for debug purposes
		System.out.println("name of employee is" + employee.getName());
		System.out.println("form employee details is" + employee);

		return "successPage";
	}

	//to update employee
	@RequestMapping(value = "/updateEmployee")
	public String updateAnEmployee(@ModelAttribute("employee") Employee employee) {

		// call DAO method
		employeeDao.updateAnEmployee(employee);

		//debug purposes
		System.out.println("name of employee is" + employee.getName());
		System.out.println("form employee details is" + employee);

		return "successPage";
	}

	//to delete employee
	@RequestMapping(value = "/deleteEmployee")
	public String deleteAnEmployee(@ModelAttribute("employee") Employee employee) {

		// call DAO method
		employeeDao.deleteAnEmployee(employee.getId());

		//debug sysouts
		System.out.println("name of employee is" + employee.getName());
		System.out.println("form employee details is" + employee);

		return "successPage";
	}

}
