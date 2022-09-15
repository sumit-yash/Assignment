//7.WAP to demonstrate exception chaining.

package com.yash.exceptions.Question7;

import java.io.IOException;

public class ExceptionChaining {

	public static void main(String[] args) throws Throwable {
		try {
			throw new ArithmeticException("Top Level Exception.").initCause(new IOException("IO cause."));
		} catch (ArithmeticException ae) {
			System.out.println("Caught : " + ae);
			System.out.println("Actual cause: " + ae.getCause());
		}
	}

}
