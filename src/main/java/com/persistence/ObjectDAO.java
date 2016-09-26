package com.persistence;

import java.util.Set;

import org.hibernate.SessionFactory;

/**
 * Interface
 * @author joseo_000
 * This interface contains
 * all methods to interact with
 * DB
 */
public interface ObjectDAO {
	
	public Integer addRecords(String fName, String lName, int salary, int address);
	
	public void listRecords();
	
	public void UpdateRecord(Integer id, int salary);
	
	public void DeleteRecord(Integer recordID);
	
}
