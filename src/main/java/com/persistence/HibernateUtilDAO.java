package com.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org. hibernate. HibernateException;
import org. hibernate. Session;
import org. hibernate. Transaction;

import com.hibernatetutorial.AddressDTO;
import com.hibernatetutorial.CertificateDTO;
import com.hibernatetutorial.EmployeeDTO;
import com.hibernatetutorial.EmployeeListCollectionDTO;
import com.hibernatetutorial.EmployeeManyToOneDTO;
import com.hibernatetutorial.EmployeeMapCollectionDTO;
import com.hibernatetutorial.EmployeeSetCollectionDTO;

/**
 * 
 * @author joseo_000
 * Util Class with methods 
 * to interact with DB
 */
public class HibernateUtilDAO implements ObjectDAO{
	
	public void listRecords() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM EmployeeDTO").list();
			for(Iterator iterator = employees.iterator(); iterator.hasNext();){
				EmployeeDTO employee = (EmployeeDTO) iterator.next();
				System.out.println("First Name: "+employee.getfName());
				System.out.println("  Last Name: "+employee.getlName());
				System.out.println("  Salary: "+employee.getSalary());
				System.out.println(" Address: "+employee.getAddress());
			}
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void listRecordsWithCollection(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM EmployeeSetCollectionDTO").list();
			for(Iterator iterator = employees.iterator(); iterator.hasNext();){
				EmployeeSetCollectionDTO employee = (EmployeeSetCollectionDTO) iterator.next();
				System.out.println("First Name: "+employee.getfName());
				System.out.println("  Last Name: "+employee.getlName());
				System.out.println("  Salary: "+employee.getSalary());
			
				Set cetificatesCollection = employee.getCertificates();
				for(Iterator iterator2 = cetificatesCollection.iterator(); iterator2.hasNext();){
					CertificateDTO certName = (CertificateDTO) iterator2.next();
					System.out.println("Certificate: "+certName.getcName());
				}
			}
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	 }
	
	public void listRecordsWithListCollection(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM EmployeeListCollectionDTO").list();
			for(Iterator iterator = employees.iterator(); iterator.hasNext();){
				EmployeeListCollectionDTO employee = (EmployeeListCollectionDTO) iterator.next();
				System.out.println("First Name: "+employee.getId()+"--"+employee.getfName());
				System.out.println("  Last Name: "+employee.getlName());
				System.out.println("  Salary: "+employee.getSalary());
			
				List cetificatesCollection = employee.getCertificates();
				for(Iterator iterator2 = cetificatesCollection.iterator(); iterator2.hasNext();){
					CertificateDTO certName = (CertificateDTO) iterator2.next();
					System.out.println("Certificate: "+certName.getcName());
				}
			}
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	 }
	
	public void listRecordsWithMapCollection(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM EmployeeMapCollectionDTO").list();
			for(Iterator iterator = employees.iterator(); iterator.hasNext();){
				EmployeeMapCollectionDTO employee = (EmployeeMapCollectionDTO) iterator.next();
				System.out.println("First Name: "+employee.getId()+"--"+employee.getfName());
				System.out.println("  Last Name: "+employee.getlName());
				System.out.println("  Salary: "+employee.getSalary());
			
				Map cetificatesCollection = employee.getCertificates();
				if(!cetificatesCollection.isEmpty()&& !cetificatesCollection.containsValue("null")){
					//System. out. println("Certificate: " +
					//		 (((CertificateDTO) cetificatesCollection. get("ComputerScience" )). getcName()));
							 System. out. println("Certificate: " +
							 (((CertificateDTO) cetificatesCollection. get("BusinessManagement" )). getcName()));
							 System. out. println("Certificate: " +
							 (((CertificateDTO) cetificatesCollection. get("ProjectManagement" )). getcName()));
				}
				
			}
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	 }
	
	public void listEmployeeManyToOne(){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM EmployeeManyToOneDTO").list();
			for(Iterator iterator = employees.iterator(); iterator.hasNext();){
				EmployeeManyToOneDTO employee = (EmployeeManyToOneDTO)iterator.next();
				System.out.println("First Name: "+ employee.getFirstName());
				System.out.println("Last Name: "+ employee.getLastName());
				System.out.println("Salary: "+ employee.getSalary());
				
				AddressDTO address = employee.getAddress();
				System.out.println("Address ");
				System.out.println("Street: "+ address.getStreet());
				System.out.println("City : "+ address.getCity());
				System.out.println("State : "+ address.getState());
				System.out.println("Zipcode : "+ address.getZipcode());
			}
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public Integer addRecords(String fName, String lName, int salary, int address) {
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		Integer recordID = null;
		
		try{
			tx = session.beginTransaction();
			EmployeeDTO employee = new EmployeeDTO(fName, lName, salary, address);
			recordID = (Integer) session.save(employee);
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return recordID;
		
	}
	
	public void addRecordsWithCollection(String fName, String lName, int salary, int address, ArrayList<String> cert){
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try{
			tx = session.beginTransaction();
			EmployeeListCollectionDTO employee = new EmployeeListCollectionDTO(fName, lName, salary, address);
			employee.setCertificates(cert);
			employeeID = (Integer)session.save(employee);
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void UpdateRecord(Integer id, int salary) {
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			EmployeeDTO employee = (EmployeeDTO)session.get(EmployeeDTO.class, id);
			employee.setSalary(salary);
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
		
	}

	public void DeleteRecord(Integer recordID) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			EmployeeDTO employee = (EmployeeDTO)session.get(EmployeeDTO.class, recordID);
			session.delete(employee);
			tx.commit();
		}catch(HibernateException ex){
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}	
}
