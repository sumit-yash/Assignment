package com.yash.java8.StreamApi_Question1;

import java.time.LocalDateTime;

public class Item {

	private int itemid;
	private String iname;
	private LocalDateTime dom, doe;
	private float price;

	public Item(int itemid, String iname, LocalDateTime dom, LocalDateTime doe, float price) {
	        super();
	        this.itemid = itemid;
	        this.iname = iname;
	        this.dom = dom;
	        this.doe = doe;
	        this.price = price;
	    }

	public Item(String iname, float price) {
	        this.iname = iname;
	        this.price = price;
	    }

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public LocalDateTime getDom() {
		return dom;
	}

	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}

	public LocalDateTime getDoe() {
		return doe;
	}

	public void setDoe(LocalDateTime doe) {
		this.doe = doe;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemStream [itemid=" + itemid + ", iname=" + iname + ", date_of_manufacturing=" + dom
				+ ", date_of_expiry=" + doe + ", price=" + price + "]";
	}

}
