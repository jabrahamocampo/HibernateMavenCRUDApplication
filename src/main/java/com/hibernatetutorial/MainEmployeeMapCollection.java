package com.hibernatetutorial;

import com.persistence.HibernateUtilDAO;

public class MainEmployeeMapCollection {
	public static void main(String[] args){
		HibernateUtilDAO employee = new HibernateUtilDAO();
		
		System.out.println("******************** Listing Records ********************");
		employee.listRecordsWithMapCollection();
	}
}
