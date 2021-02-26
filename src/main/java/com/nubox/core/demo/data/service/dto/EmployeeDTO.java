package com.nubox.core.demo.data.service.dto;

import com.nubox.core.demo.data.common.bind.DTO;

@DTO
public class EmployeeDTO {
	
    
	public Long id;

    public String firstName;

    public String lastName;

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



    
    
}
