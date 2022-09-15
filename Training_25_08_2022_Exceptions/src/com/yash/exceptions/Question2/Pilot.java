/*
 * 1.An employee can not take more than 2 leaves in a month if he takes more than two leave you need
		to throw the exception. LeaveExceedLimitException.
 *2.If for any employee N is continuously for four days you need to throw exception
	EmployeeAbscondingException. In this case salary will not be calculated.
 *3.If all goes good you need to print the total salary of employee for that particular month.
 */

package com.yash.exceptions.Question2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class EmployeeAbscondingException extends Exception {
	String response;

	public EmployeeAbscondingException(String response) {
		super(response);
	}
}

class LeaveExceedLimitException extends Exception {
	String response;

	public LeaveExceedLimitException(String response) {
		super(response);
	}
}

public class Pilot {
	static String[] attaindanceArray = new String[6];

	private static void getAttendance(Employee emp) {
		System.out.println("P for present, L for leave it will be paid leave," + " A for absent, \r\n"
				+ "N for no information about a day.");
		Scanner sc = new Scanner(System.in);
		int day = 0;
		while (day < 6) {
			System.out.println("Please enter your attaindance for the day");
			String attaindance = sc.next();
			try {
				attaindanceArray[day] = attaindance;
			} catch (Exception e) {
				e.printStackTrace();
			}
			day++;
		}
		calculateAttendance(attaindanceArray,emp);
	}

	private static void calculateAttendance(String[] attaindanceArr,Employee emp) {
		int pCount=0;
		int nCount=0;
		int lCount=0;
		int aCount=0;
		HashMap<String, Integer> map=new HashMap<>();
		if (attaindanceArr != null && attaindanceArr.length > 0) {
			for (String element : attaindanceArr) {
//				System.out.println("attaindanceArr["+i+"]= "+attaindanceArr[i]);
				if(element == null) {
					break;
				}
				if (map.containsKey(element)) {
					map.put(element, map.get(element)+1);
				}else {
					map.put(element, 1);
				}
			}
		}

		for (Map.Entry<String, Integer> m : map.entrySet()) {
			if (m.getKey().equalsIgnoreCase("P")) {
				pCount=m.getValue();
			}
			else if (m.getKey().equalsIgnoreCase("A")) {
				aCount=m.getValue();
			}
			else if (m.getKey().equalsIgnoreCase("N")) {
				nCount=m.getValue();
			}
			else if (m.getKey().equalsIgnoreCase("L")) {
				lCount=m.getValue();
			}

		}

		System.out.println("Present Days="+pCount);
		System.out.println("Absent Days="+aCount);
		System.out.println("No Info Days="+nCount);
		System.out.println("Leave Days="+lCount);
		try {
			if (lCount > 2) {
				throw new LeaveExceedLimitException("Leave limit is exceeded = " + lCount);
			}
			if (nCount > 4) {
				throw new EmployeeAbscondingException("No information leave exceed its limit = " + nCount);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if(nCount<4) {
			System.out.println("Employee Salary for a "+pCount+" days= "+(emp.getEmpSalary()*pCount));
		}

	}

	public static void main(String[] args) {
		Employee employee1 = new Employee(1001, "sumit", 200.20);
		Employee employee2 = new Employee(1002, "Abhi", 400.20);

		getAttendance(employee1);
	}

}
