package com.hibernatetutorial;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persistence.*;

public class ListStockRecords {
	
	public static void main(String[] args){
		System.out.println("Listing current records");
		ListStockRecords li = new ListStockRecords();
		li.listRecords();
	}
	
	public static void listRecords(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Stock").list();
			for(Iterator iterator = records.iterator(); iterator.hasNext();){
				Stock stock = (Stock) iterator.next();
				System.out.println("Record name and code: "+stock.getStockName()+" -- "+stock.getStockCode());
				
			}
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}
}
