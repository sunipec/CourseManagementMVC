package com.digit.projectCRDModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentModel {

	int sid;
	String sname;
	int c_id;
	String email;
	String cname;
	private Connection con;
	private PreparedStatement pstmt;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public StudentModel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			String url = "jdbc:mysql://localhost:3306/crsmvc";
			String user = "root";
			String pwd = "1234";

			// Step 2
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addStud() {
		try {
			String sql = "insert into student values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			pstmt.setInt(2, c_id);
			pstmt.setString(3, sname);
			pstmt.setString(4, email);
			pstmt.setString(5, cname);
			pstmt.setInt(6, -1);

			int x = pstmt.executeUpdate();
			if (x > 0) {
				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	public boolean removeStud() {
		try {
			String sql = "delete from student where sid=? and sname=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			
			pstmt.setString(2, sname);
			
			

			int x = pstmt.executeUpdate();
			if (x > 0) {
				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean gradeStudent(int marks) {
		try {
			String sql = "update student set marks=? where sid=? and sname=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, marks);
			pstmt.setInt(2, sid);
			
			pstmt.setString(3, sname);
			
			

			int x = pstmt.executeUpdate();
			if (x > 0) {
				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
