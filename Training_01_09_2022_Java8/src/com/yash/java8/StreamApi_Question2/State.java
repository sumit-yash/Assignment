package com.yash.java8.StreamApi_Question2;

public class State {
	int stated;
	String statename;
	public int getStated() {
		return stated;
	}
	public void setStated(int stated) {
		this.stated = stated;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	@Override
	public String toString() {
		return "State [stated=" + stated + ", statename=" + statename + "]";
	}
	public State(int stated, String statename) {
		super();
		this.stated = stated;
		this.statename = statename;
	}
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
