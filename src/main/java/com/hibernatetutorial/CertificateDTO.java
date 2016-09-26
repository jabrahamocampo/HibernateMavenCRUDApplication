package com.hibernatetutorial;

public class CertificateDTO implements Comparable<CertificateDTO>{
	
	private int id;
	private String cName;
	private int empId;
	private String cType;
	
	public CertificateDTO(){
		
	}
	
	public CertificateDTO(String name){
		this.cName = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public int compareTo(CertificateDTO that) {
		final int BEFORE = -1;
		final int AFTER = 1;
		
		if(that == null){
			return BEFORE;
		}
		
		Comparable thisCertificate = this.getcName();
		Comparable thatCertificate = this.getcName();
		
		if(thisCertificate == null){
			return AFTER;
		}else if(thatCertificate == null){
			return BEFORE;
		}else{
			return thisCertificate.compareTo(thatCertificate);
		}
	}
}
