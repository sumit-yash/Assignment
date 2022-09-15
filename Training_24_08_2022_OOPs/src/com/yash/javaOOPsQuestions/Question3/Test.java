package com.yash.javaOOPsQuestions.Question3;

import java.util.Iterator;
import java.util.Scanner;

public class Test {
	 Customer_Account_Statement[] cas=new Customer_Account_Statement[4];;
	Customer[] customerArr=new Customer[4];
	
	private Customer getCustomerDetails(String custNum) {
		Customer customer=null;
		for(int i=0;i<customerArr.length;i++) {
			if(customerArr[i].getCustId().equals(custNum)) {
				customer=customerArr[i];
			}
		}
		return customer;
	}
	
	private void getCustomerAccountStatementDetails(String custNum) {
		Object[] obj=new Object[2];
		for(int i=0;i<cas.length;i++) {
			Customer_Account_Statement cs=cas[i];
			if((custNum).equals( cs.getCustId())) {
				System.out.println("CustomerAccountStatement="+cs);
				Customer custDetails = getCustomerDetails(custNum);
				System.out.println("For Customer="+custDetails);
			}
		}
	}
	
	public static void main(String[] args) {
		Test t=new Test();
			
	
			//branch objects
			Branch branch1=new Branch("BU11111","wd_tresory","Wardha");
			Branch branch2=new Branch("BU11112","amt_tresory","Amaravati");
			Branch branch3=new Branch("BU11113","y_tresory","Yavatmal");
			Branch branch4=new Branch("BU11114","n_tresory","Nagpur");
			
			//Customer objects
			Customer customer1=new Customer("CUS2221",11111111,"sumit","wardha","16081996","06072022",branch1);
			Customer customer2=new Customer("CUS2222",11111112,"amit","amravati","6021991","04072020",branch2);
			Customer customer3=new Customer("CUS2223",11111113,"vijay","yavatmal","07031992","14102021",branch3);
			Customer customer4=new Customer("CUS2224",11111114,"jiten","nagpur","22071993","21071995",branch4);
			
			//Customer_Account_Statement objects
			Customer_Account_Statement custAccStmt1=new Customer_Account_Statement(
					"CAS33331",customer1.getCustId(),2000,"withdraw","06082022"
					);
			
			Customer_Account_Statement custAccStmt2=new Customer_Account_Statement(
					"CAS33332",customer2.getCustId(),4000,"deposit","09102021"
					);
			
			Customer_Account_Statement custAccStmt3=new Customer_Account_Statement(
					"CAS33333",customer3.getCustId(),6000,"withdraw","05042022"
					);
			
			Customer_Account_Statement custAccStmt4=new Customer_Account_Statement(
					"CAS33334",customer4.getCustId(),8000,"deposit","25121997"
					);
		
			t.cas[0]=custAccStmt1;
			t.cas[1]=custAccStmt2;
			t.cas[2]=custAccStmt3;
			t.cas[3]=custAccStmt4;
			t.customerArr[0]=customer1;
			t.customerArr[1]=customer2;
			t.customerArr[2]=customer3;
			t.customerArr[3]=customer4;
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter CustomerId");
			String custId=sc.next();
			Customer cs = null;
			Customer_Account_Statement stmt=null;
			
			t.getCustomerAccountStatementDetails(custId);
			
			
			
	}
	
	
	

}
