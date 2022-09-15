package com.yash.exceptions.Question4;

public class ItemBought {
	private int itemId;
	private int itemQty;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	@Override
	public String toString() {
		return "ItemBought [itemId=" + itemId + ", itemQty=" + itemQty + "]";
	}

	public ItemBought(int itemId, int itemQty) {
		super();
		this.itemId = itemId;
		this.itemQty = itemQty;
	}

	public ItemBought() {
		super();
		// TODO Auto-generated constructor stub
	}

}
