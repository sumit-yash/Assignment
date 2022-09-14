package com.yash.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yash.project.entity.Student;

public class StudentDaoImpl implements StudentDao{
	private Connection connection=null;
	private final String INSERT_QUERY="insert into student(rollNo,name,address) values(?,?,?)";
	private final String UPDATE_QUERY="update student set name=?,address=? where rollNo=?";
	private final String GET_SINGLE_QUERY="select * from student where rollNo=?";
	private final String DELETE_QUERY="delete from student where rollNo=?";
	private final String GET_QUERY="select * from student";
	
	private Connection getConnection(Connection con) {
		try {
			if(con == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
//			st=con.createStatement();
			}
		}catch(Exception e) {
			System.out.println("Exception ="+e);
		}
		return con;
	}
	
	private void closeConnection(Connection con) {
		if(con!=null) {
			try {
//				con.commit();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//static list of student
	private static List<Student> stuList=new ArrayList<>(Arrays.asList(
				new Student(1, "sumit", "wardha"),
				new Student(2, "vijay", "akola"),
				new Student(3, "ajat", "nagpur"),
				new Student(4, "pankaj", "amaravti")));
	

	@Override
	public int addStudent(Student stu) {
//		stuList.add(stu);
//		System.out.println("Student Added entity= "+stuList);
		Connection con=null;
		PreparedStatement ps=null;
		int executeUpdate=0;
		try {
			con = getConnection(con);
			ps= con.prepareStatement(INSERT_QUERY);
			ps.setInt(1, stu.getRollNo());
			ps.setString(2, stu.getName());
			ps.setString(3, stu.getAddress());
			executeUpdate= ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("Exception at adding student= "+e);
		}finally {
			closeConnection(con);
		}
		
		return executeUpdate;
	}

	@Override
	public Student updateStudent(Student stu) {
//		Student student = getStudent(stu.getRollNo());
//		if(student!= null) {
//			student.setAddress(stu.getAddress());
//			student.setName(stu.getName());
//			student.setRollNo(stu.getRollNo());
//		}
		Student student=new Student();
		Connection con=null;
		PreparedStatement ps=null;
		int excuteUpdate=0;
		student=getStudent(stu.getRollNo());
		if(student != null) {
		try {
			con=getConnection(con);
			ps=con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getAddress());
			ps.setInt(3, stu.getRollNo());
			excuteUpdate= ps.executeUpdate();
			if(excuteUpdate!=0) {
				student = getStudent(stu.getRollNo());
			}
		}catch(Exception e) {
			System.out.println("Exception at updateStudent= "+e);
		}finally {
			closeConnection(con);
		}
		}else {
			student=null;
		}
		return student;
	}

	@Override
	public int deleteStudent(int studId) {
		Connection con=null;
		PreparedStatement ps=null;
		int executeUpdate =0;
		try {
			con=getConnection(con);
			ps=con.prepareStatement(DELETE_QUERY);
			ps.setInt(1, studId);
			executeUpdate= ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Exception in deleteStudent = "+e);
		}finally {
			closeConnection(con);
		}
		
		return executeUpdate;
	}

	@Override
	public Student getStudent(int studId) {
		Student st=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=getConnection(con);
			ps=con.prepareStatement(GET_SINGLE_QUERY);
			ps.setInt(1, studId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int rollNo=rs.getInt("rollNo");
				String name=rs.getString("name");
				String address=rs.getString("address");
				st=new Student(rollNo,name,address);
			}
		}catch(Exception e) {
			System.out.println("Exception in getStudent = "+e);
		}finally {
			closeConnection(con);
		}
		return st;
	}

	@Override
	public List<Student> getAllStudents() {
		Connection con=null;
		PreparedStatement ps=null;
		List<Student> studentList=new ArrayList<>();
		try {
			con=getConnection(con);
			ps=con.prepareStatement(GET_QUERY);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 
				 int rollNo=rs.getInt("rollNo");
				 String name=rs.getString("name");
				 String address=rs.getString("address");
				 Student st=new Student(rollNo,name,address);
				 if(st!= null) {
					 studentList.add(st);
				 }
			 }
		}catch(Exception e) {
			System.out.println("Exception at getAllStudents ="+e);
		}finally {
			closeConnection(con);
		}
		return studentList;
	}

}
