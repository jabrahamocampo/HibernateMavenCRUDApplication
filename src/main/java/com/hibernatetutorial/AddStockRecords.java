package com.hibernatetutorial;

import org.hibernate.Session;
import com.persistence.*;

public class AddStockRecords {
	public static void main(String[] args){
		System.out.println("Maven+Hibernate+MySql");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Stock stock = new Stock();
		
		stock.setStockCode("123456");
		stock.setStockName("PDFGH");
		
		session.save(stock);
		session.getTransaction().commit();
	}
}
