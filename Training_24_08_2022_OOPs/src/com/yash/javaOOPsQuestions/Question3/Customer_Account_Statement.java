package com.yash.javaOOPsQuestions.Question3;

public class Customer_Account_Statement {
	private String CAID;
	private String CustId;
	private int amount;
	private String deposit_withdrawl;
	private String deposit_date;
	
	
	public String getCAID() {
		return CAID;
	}
	public void setCAID(String cAID) {
		CAID = cAID;
	}
	public String getCustId() {
		return CustId;
	}
	public void setCustId(String custId) {
		CustId = custId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDeposit_withdrawl() {
		return deposit_withdrawl;
	}
	public void setDeposit_withdrawl(String deposit_withdrawl) {
		this.deposit_withdrawl = deposit_withdrawl;
	}
	public String getDeposit_date() {
		return deposit_date;
	}
	public void setDeposit_date(String deposit_date) {
		this.deposit_date = deposit_date;
	}
	@Override
	public String toString() {
		return "Customer_Account_Statement [CAID=" + CAID + ", \nCustId=" + CustId + ", \namount=" + amount
				+ ", \ndeposit_withdrawl=" + deposit_withdrawl + ", \ndeposit_date=" + deposit_date + "]";
	}
	public Customer_Account_Statement(String cAID, String custId, int amount, String deposit_withdrawl,
			String deposit_date) {
		super();
		CAID = cAID;
		CustId = custId;
		this.amount = amount;
		this.deposit_withdrawl = deposit_withdrawl;
		this.deposit_date = deposit_date;
	}
	public Customer_Account_Statement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
