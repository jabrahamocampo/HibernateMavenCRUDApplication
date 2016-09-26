package com.hibernatetutorial;

public class EmployeeDTO {
	private Integer id;
	private String fName;
	private String lName;
	private int salary;
	private int address;
	
	public EmployeeDTO(){
		
	}
	
	public EmployeeDTO(String fName, String lName, int salary, int address){
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}
	
	
}
