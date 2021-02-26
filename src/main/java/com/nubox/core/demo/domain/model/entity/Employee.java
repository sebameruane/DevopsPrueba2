package com.nubox.core.demo.domain.model.entity;

import com.nubox.core.demo.data.common.validation.Rut;

import javax.validation.constraints.*;
import java.util.Date;


public class Employee {

	private Long id;


	@NotEmpty
	private String firstName;

	@Size(min = 2, max=100,message = "Amigo el apellido debe tener un largo entre {min}  y {max}")
	@NotBlank
	private String lastName;

	@Past
	private Date birthDate;

	@Negative
	private Integer negativeNumber;

	@PositiveOrZero
	private Integer salary;

	@Email
	@NotNull
	private String email;

	@Rut
	private String rut;

	public Employee(Long id, @NotEmpty String firstName, @Size(min = 2, max = 100, message = "Amigo el apellido debe tener un largo entre {min}  y {max}") @NotBlank String lastName, @Past Date birthDate, @Negative Integer negativeNumber, @PositiveOrZero Integer salary, @Email @NotNull String email, @Rut String rut) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.negativeNumber = negativeNumber;
		this.salary = salary;
		this.email = email;
		this.rut = rut;
	}

	public Employee(Long id, String rut, String firstName, String lastName) {
		this.id = id;
		this.rut =rut;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getNegativeNumber() {
		return negativeNumber;
	}

	public void setNegativeNumber(Integer negativeNumber) {
		this.negativeNumber = negativeNumber;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Employee orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
