package com.hibernatetutorial;

public class EmployeeManyToOneDTO {
	 private int id;
	 private String firstName;
	 private String lastName; 
	 private int salary;
	 private AddressDTO address;
	 
	 public EmployeeManyToOneDTO() {}
	 
	 public EmployeeManyToOneDTO(String fname, String lname,int salary, AddressDTO address ) {
		 this. firstName = fname;
		 this. lastName = lname;
		 this. salary = salary;
		 this. address = address;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	 
	 
}
