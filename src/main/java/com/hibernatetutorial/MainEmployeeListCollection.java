package com.hibernatetutorial;

import java.util.ArrayList;
import java.util.List;

import com.persistence.HibernateUtilDAO;

public class MainEmployeeListCollection {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		HibernateUtilDAO employee = new HibernateUtilDAO();
		
		ArrayList cert = new ArrayList();
		cert.add(new CertificateDTO("SCJP"));
		cert.add(new CertificateDTO("ORACLE"));
		cert.add(new CertificateDTO("DUFF"));
		
		System.out.println("******************** Adding new Records ********************");
		employee.addRecordsWithCollection("Joselo", "Casillas", 33000, 1, cert);
		
		
		System.out.println("******************** Listing Records ********************");
		employee.listRecordsWithListCollection();
	}
}
