package com.yash.ioc.Question5;

public class SetterMessage {
	private String message=null;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SetterMessage [message=" + message + "]";
	}
	
	
	
}
