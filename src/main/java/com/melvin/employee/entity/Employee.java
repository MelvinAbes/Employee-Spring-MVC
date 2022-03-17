package com.melvin.employee.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob")
	private Date dob;

	@Column(name = "age")
	private int age;

	@Column(name = "salary")
	private int salary;

	@Column(name = "status")
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;

		LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dob));
		setAge(localDate, LocalDate.now());
	}

	public int getAge() {
		return age;
	}

	public void setAge(LocalDate birthDate, LocalDate currentDate) {

		int calculatedAge = Period.between(birthDate, currentDate).getYears();

		this.age = calculatedAge;

	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age
				+ ", salary=" + salary + ", status=" + status + "]";
	}

}
