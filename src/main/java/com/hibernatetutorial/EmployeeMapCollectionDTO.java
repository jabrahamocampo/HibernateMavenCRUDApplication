package com.hibernatetutorial;

import java.util.Map;
import java.util.Set;

public class EmployeeMapCollectionDTO {
	private Integer id;
	private String fName;
	private String lName;
	private int salary;
	private int address;
	private Map certificates;
	
	public EmployeeMapCollectionDTO(){
		
	}
	
	public EmployeeMapCollectionDTO(String fName, String lName, int salary, int address){
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

	public Map getCertificates() {
		return certificates;
	}

	public void setCertificates(Map certificates) {
		this.certificates = certificates;
	}
}
