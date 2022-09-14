//6.WAP to demonstrate how memory is allocated to string objects in 
//memory heap and string constant pool.
package com.yash.StringDemo.Question6;

public class StringObjectMemory_6 {
	public static void main(String[] args) {
		String s1=new String("sumit"); //2
//		String s2=new String("sumit");
		String s3="sumit"; //0
		String s4="sumit"; //0
		System.out.println("s1="+s1+" and hashcode="+s1.hashCode());
		System.out.println("hashcode s3="+s3.hashCode());
		System.out.println("hashcode s4="+s4.hashCode());
		System.out.println("s1==s3 ="+(s1==s3));
	}

}
