package com.yash.javaOOPsQuestions.Question11;

class Electronics {
	private int id;
	private String semiConductorType;
	private String dateOfmanifacturing;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSemiConductorType() {
		return semiConductorType;
	}

	public void setSemiConductorType(String semiConductorType) {
		this.semiConductorType = semiConductorType;
	}

	public String getDateOfmanifacturing() {
		return dateOfmanifacturing;
	}

	public void setDateOfmanifacturing(String dateOfmanifacturing) {
		this.dateOfmanifacturing = dateOfmanifacturing;
	}

	@Override
	public String toString() {
		return "Electronics [id=" + id + ", semiConductorType=" + semiConductorType + ", dateOfmanifacturing="
				+ dateOfmanifacturing + "]";
	}

	public Electronics(int id, String semiConductorType, String dateOfmanifacturing) {
		super();
		this.id = id;
		this.semiConductorType = semiConductorType;
		this.dateOfmanifacturing = dateOfmanifacturing;
	}

	public Electronics() {
		super();
		// TODO Auto-generated constructor stub
	}

}

class Mobile extends Electronics {

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(int id, String semiConductorType, String dateOfmanifacturing) {
		super(id, semiConductorType, dateOfmanifacturing);
		// TODO Auto-generated constructor stub
	}

	
	
}

class LCD extends Electronics {

	public LCD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LCD(int id, String semiConductorType, String dateOfmanifacturing) {
		super(id, semiConductorType, dateOfmanifacturing);
		// TODO Auto-generated constructor stub
	}
	
}

class Laptop extends Electronics {

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(int id, String semiConductorType, String dateOfmanifacturing) {
		super(id, semiConductorType, dateOfmanifacturing);
		// TODO Auto-generated constructor stub
	}
	
}

public class Electronics_Question_8 {
	
	
	public static void main(String[] args) {
		Electronics e1=new Electronics(1, "silicon", "11022022");
		Electronics e2=new Mobile(2, "silicon1", "14022022");
		Electronics e3=new LCD(3, "silicon2", "15022022");
		Electronics e4=new Laptop(4, "silicon3", "17022022");
		
		System.out.println("Electronic="+e1);
		System.out.println("Mobile="+e2);
		System.out.println("LCD="+e3);
		System.out.println("Laptop="+e4);
	}
	
}
