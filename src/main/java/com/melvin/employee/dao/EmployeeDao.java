package com.melvin.employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


import com.melvin.employee.entity.Employee;

@Component
public class EmployeeDao implements IEmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {

		// create an array list to hold the list of employees
		List<Employee> listOfEmployees = new ArrayList<Employee>();

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			listOfEmployees = session.createQuery("from Employee").getResultList();

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {

			factory.close();
		}

		return listOfEmployees;
	}

	@Override
	public Boolean addAnEmployee(Employee employee) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			//debug sysout
			System.out.println("imside addAnEmployee method");

			// save the student object
			System.out.println("Saving the employee....");
			session.save(employee);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {

			factory.close();
		}

		return true;
	}

	@Override
	public Employee getEmployee(int id) {

		// create an array list to hold the list of employees
		Employee anEmployee = new Employee();

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get student
			anEmployee = session.get(Employee.class, id);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {

			factory.close();
		}

		return anEmployee;

	}

	@Override
	public Boolean updateAnEmployee(Employee employee) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		//debug sysout
		System.out.println("inside update employee method");

		try {

			// start a transaction
			session.beginTransaction();

			Employee employeeInDb = session.get(Employee.class, employee.getId());

			System.out.println("empl infomrain is " + employee);

			employeeInDb.setName(employee.getName());
			employeeInDb.setEmail(employee.getEmail());
			employeeInDb.setDob(employee.getDob());
			employeeInDb.setSalary(employee.getSalary());
			employeeInDb.setStatus(employee.getStatus());

			session.update(employeeInDb);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {

			factory.close();
		}

		return true;

	}

	@Override
	public Boolean deleteAnEmployee(int id) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {


			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// debug purpose sysout
			System.out.println("\nGetting employee with id: " + id);

			Employee employee = session.get(Employee.class, id);

			//delete the student
			System.out.println("Deleting employee: " + employee);
			session.delete(employee);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {

			factory.close();
		}

		return true;
	}

}
