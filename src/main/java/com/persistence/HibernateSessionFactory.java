package com.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author joseo_000
 *This class create the
 *SessionFactoy Object
 */

public class HibernateSessionFactory {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	public static SessionFactory buildSessionFactory(){
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Failed to create SessionFactory object" + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
