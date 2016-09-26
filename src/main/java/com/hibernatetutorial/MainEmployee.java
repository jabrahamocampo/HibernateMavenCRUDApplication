package com.hibernatetutorial;

import com.persistence.HibernateUtilDAO;

public class MainEmployee {
	public static void main(String[] args){
		HibernateUtilDAO employee = new HibernateUtilDAO();
		System.out.println("******************** Listing Records ********************");
		employee.listRecords();
		
		System.out.println("******************** Adding New Records ********************");
		employee.addRecords("Jose Abraham", "Ocampo", 33000, 4);
		
		System.out.println("******************** Uopdate Records ********************");
		employee.UpdateRecord(77, 4200);
		
		System.out.println("******************** Delete Records ********************");
		employee.DeleteRecord(82);
	}
}
