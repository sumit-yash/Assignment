package com.yash.javaOOPsQuestions.Question3;

public class Customer {
	private String CustId;
	private long accountno;
	private String custname;
	private String cust_address;
	private String cust_dob;
	private String cust_account_opening_date;
	private Branch Branch_Obj;
	
	
	public String getCustId() {
		return CustId;
	}
	public void setCustId(String custId) {
		CustId = custId;
	}
	public long getAccountno() {
		return accountno;
	}
	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_dob() {
		return cust_dob;
	}
	public void setCust_dob(String cust_dob) {
		this.cust_dob = cust_dob;
	}
	public String getCust_account_opening_date() {
		return cust_account_opening_date;
	}
	public void setCust_account_opening_date(String cust_account_opening_date) {
		this.cust_account_opening_date = cust_account_opening_date;
	}
	public Branch getBranch_Obj() {
		return Branch_Obj;
	}
	public void setBranch_Obj(Branch branch_Obj) {
		Branch_Obj = branch_Obj;
	}
	@Override
	public String toString() {
		return "Customer [CustId=" + CustId + ", \naccountno=" + accountno + ", \ncustname=" + custname + ", cust_address="
				+ cust_address + ", \ncust_dob=" + cust_dob + ", \ncust_account_opening_date=" + cust_account_opening_date
				+ ", \nBranch_Obj=" + Branch_Obj + "]";
	}
	public Customer(String custId, long accountno, String custname, String cust_address, String cust_dob,
			String cust_account_opening_date, Branch branch_Obj) {
		super();
		CustId = custId;
		this.accountno = accountno;
		this.custname = custname;
		this.cust_address = cust_address;
		this.cust_dob = cust_dob;
		this.cust_account_opening_date = cust_account_opening_date;
		Branch_Obj = branch_Obj;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
