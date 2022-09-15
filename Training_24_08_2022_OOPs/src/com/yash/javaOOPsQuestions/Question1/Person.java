package com.yash.javaOOPsQuestions.Question1;

class Person{
	private int pId;
	private String pName, paddress;
	private String dob;
	
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Person(int pId, String pName, String paddress, String dob) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.paddress = paddress;
		this.dob = dob;
	}
	
	
	
	
}
