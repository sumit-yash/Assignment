package com.yash.javaOOPsQuestions.Question9;

class Product implements Cloneable{
	private int pid;
	private String pname;
	private int price;
	private String unitOfMeasurement;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}
	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", unitOfMeasurement="
				+ unitOfMeasurement + "]";
	}
	public Product(int pid, String pname, int price, String unitOfMeasurement) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.unitOfMeasurement = unitOfMeasurement;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

public class Question9 {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Product p=new Product(1, "test", 100, "rupees");
		System.out.println("p="+p);
		Product p1=(Product)p.clone();
		p1.setPname("clonned");
		p1.setPrice(4);
		System.out.println("p1="+p1);
		
		System.out.println("p= "+ (p instanceof Product));
		System.out.println("p1= "+(p1 instanceof Product));
	}

}
