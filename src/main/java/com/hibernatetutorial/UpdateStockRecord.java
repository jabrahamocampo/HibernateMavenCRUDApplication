package com.hibernatetutorial;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persistence.HibernateUtil;

public class UpdateStockRecord {
	
	public static void main(String[] args){
		/*Update Record*/
		System.out.println("************ Update Record ************");
		UpdateStockRecord ur = new UpdateStockRecord();
		ur.updateRecordMethod(1, "ABCDES");
		System.out.println("************ Listing current records ************");
		ListStockRecords.listRecords();
	}
	
	public void updateRecordMethod(int id, String sName){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Stock stock = (Stock) session.get(Stock.class, id);
			stock.setStockName(sName);
			session.update(stock);
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}
	
}
