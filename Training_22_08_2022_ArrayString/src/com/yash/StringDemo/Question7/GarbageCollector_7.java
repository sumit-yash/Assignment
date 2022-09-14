//7. WAP to demonstrate how garbage collector work
//when any memory is not referenced by string object.
package com.yash.StringDemo.Question7;

public class GarbageCollector_7 {
	
	String st;

	public GarbageCollector_7(String st) {
		this.st = st;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		 System.out.println(this.st + " collected");
	}
	 
	public static void main(String[] args) {
		 GarbageCollector_7 gcc = new GarbageCollector_7("sumit"); 
		 System.out.println("String="+gcc.st.toString());
		gcc=null;
		System.gc();
//		System.out.println("String2="+gcc.st.toString());
	}

}
