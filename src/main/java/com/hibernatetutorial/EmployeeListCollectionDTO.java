package com.hibernatetutorial;

import java.util.List;

public class EmployeeListCollectionDTO {
	private Integer id;
	private String fName;
	private String lName;
	private int salary;
	private int address;
	private List<String> certificates;
	
	public EmployeeListCollectionDTO(){
		
	}
	
	public EmployeeListCollectionDTO(String fName, String lName, int salary, int address){
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

	public List getCertificates() {
		return certificates;
	}

	public void setCertificates(List certificates) {
		this.certificates = certificates;
	}
}
