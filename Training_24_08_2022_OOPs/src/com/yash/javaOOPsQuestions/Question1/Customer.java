package com.yash.javaOOPsQuestions.Question1;

public class Customer extends Person{
	private String date_of_registration;
	private String delivery_address;
	private int contactno;
	private int email_id;
	public String getDate_of_registration() {
		return date_of_registration;
	}
	public void setDate_of_registration(String date_of_registration) {
		this.date_of_registration = date_of_registration;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public int getEmail_id() {
		return email_id;
	}
	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}
	public Customer(int pId, String pName, String paddress, String dob, String date_of_registration,
			String delivery_address, int contactno, int email_id) {
		super(pId, pName, paddress, dob);
		this.date_of_registration = date_of_registration;
		this.delivery_address = delivery_address;
		this.contactno = contactno;
		this.email_id = email_id;
	}
	public Customer(int pId, String pName, String paddress, String dob) {
		super(pId, pName, paddress, dob);
	}
	
	
	
	
	
	
}
