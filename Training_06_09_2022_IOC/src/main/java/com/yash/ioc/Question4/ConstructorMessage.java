package com.yash.ioc.Question4;

public class ConstructorMessage {
	private String message=null;

	public ConstructorMessage(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ConstructorMessage [message=" + message + "]";
	}
	
	
}
