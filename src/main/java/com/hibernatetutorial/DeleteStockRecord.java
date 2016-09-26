package com.hibernatetutorial;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persistence.HibernateUtil;

public class DeleteStockRecord {
	public static void main(String[] args){
		System.out.println("*********** Deleting records now**********");
		DeleteStockRecord de = new DeleteStockRecord();
		de.deletingRecord(7);
		System.out.println("*********** Display current records now**********");
		ListStockRecords.listRecords();
	}
	
	public void deletingRecord(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, id);
			session.delete(stock);
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}
}
