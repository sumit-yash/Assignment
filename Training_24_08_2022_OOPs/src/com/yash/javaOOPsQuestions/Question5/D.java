//Question 5
package com.yash.javaOOPsQuestions.Question5;

abstract class CalcAbs{
	void sum(int a, int b) {
		System.out.println("inside abstract class CalcAbs sum method");
	}
	void sub(int a, int b) {
		System.out.println("inside abstract class CalcAbs sub method");
	}
	void mul(int a, int b) {
		System.out.println("inside abstract class CalcAbs mul method");
	}
	void div(int a,int b) {
		System.out.println("inside abstract class CalcAbs div method");
	}
}

class A extends CalcAbs{
	@Override
	void sum(int a, int b) {
		System.out.println("inside A class sum method");
	}
}
class B extends A{
	@Override
	void sub(int a, int b) {
		System.out.println("inside B class  sub method");
	}
}
class C extends B{
	@Override
	void mul(int a, int b) {
		System.out.println("inside C class mul method");
	}
	
}
class D extends C{
	@Override
	void div(int a, int b) {
		System.out.println("inside D class div method");
	}
	
	public static void main(String[] args) {
		CalcAbs a=new A();
		CalcAbs b=new B();
		CalcAbs c=new C();
		CalcAbs d=new D();
		
		a.sum(1, 1);
		b.sub(0, 0);
		c.mul(0, 0);
		d.div(0, 0);
	}
	
}

