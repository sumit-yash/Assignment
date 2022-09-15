package com.yash.exceptions.Question4;

public class Categories {
	private int catid;
	private String categoryName;

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Categories [catid=" + catid + ", categoryName=" + categoryName + "]";
	}

	public Categories(int catid, String categoryName) {
		super();
		this.catid = catid;
		this.categoryName = categoryName;
	}

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

}
