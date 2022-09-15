package com.yash.collectionDemo.Question7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Pilot {
	private static int outOfmrks=500;
	
	
	private static void checkTopper(List<Student> studentList) {
		Collections.sort(studentList,new Comparator<Student>() {

			@Override
			public int compare(Student stu1, Student stu2) {
				int mrk1=stu1.getTotalmarks();
				int mrk2=stu2.getTotalmarks();
				if(mrk1>mrk2) {
					return -1;
				}else if(mrk1<mrk2) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		System.out.println(studentList);
	}
	
	//for print students whos marks are <50%
	private static void lowMrkStudent(List<Student> stuList){
		for (Student student : stuList) {
			int avg=student.getTotalmarks()*100/500;
			if(avg<50) {
				System.out.println("Avg below 50%= "+avg);
				System.out.println(student);
			}
			if(avg<35) {
				System.out.println("Avg below 35%= "+avg);
				System.out.println(student);
			}
			if(avg>60) {
				System.out.println("Avg more than 60%= "+avg);
				System.out.println(student);
			}
		}
	}
	
	//print name of students
	private static void nameOfStudents(List<Student> stuList) {
		Collections.sort(stuList,new Comparator<Student>() {

			@Override
			public int compare(Student st1, Student st2) {
				String sname1=st1.getSname();
				String sname2=st2.getSname();
				
				return sname2.compareTo(sname1);
			}
		});
		System.out.println(stuList);
	}
	
	public static void main(String[] args) {
		List<Student> studentList=new ArrayList<>();
		studentList.add(new Student(1, "sumit", "A", 400));
		studentList.add(new Student(2, "ajit", "A", 240));
		studentList.add(new Student(3, "vinit", "A", 350));
		studentList.add(new Student(4, "kamlesh", "A", 420));
		studentList.add(new Student(5, "jay", "A", 200));
		studentList.add(new Student(6, "mike", "A", 100));
		
		checkTopper(studentList);
		lowMrkStudent(studentList);
		nameOfStudents(studentList);
	}


	

}
