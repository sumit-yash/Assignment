package com.yash.javaOOPsQuestions.Question3;

public class Branch {
	private String branch_id;
	private String branch_name;
	private String branch_address;
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getBranch_address() {
		return branch_address;
	}
	public void setBranch_address(String branch_address) {
		this.branch_address = branch_address;
	}
	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", \nbranch_name=" + branch_name + ", \nbranch_address=" + branch_address
				+ "]";
	}
	public Branch(String branch_id, String branch_name, String branch_address) {
		super();
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.branch_address = branch_address;
	}
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
