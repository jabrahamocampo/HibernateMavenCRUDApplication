package com.hibernatetutorial;

import com.persistence.HibernateUtilDAO;

public class MainEmployeeManyToOne {
	public static void main(String[] args){
		HibernateUtilDAO employee = new HibernateUtilDAO();
		employee.listEmployeeManyToOne();
	}
}
