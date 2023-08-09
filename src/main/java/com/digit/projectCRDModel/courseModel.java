package com.digit.projectCRDModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class courseModel {

	int cid;
	String cname;
	int fees;
	int dur_month;
	private Connection con;
	private PreparedStatement pstmt;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getDur_month() {
		return dur_month;
	}

	public void setDur_month(int dur_month) {
		this.dur_month = dur_month;
	}

	public courseModel() {
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

	public boolean addCourse() {
		try {
			String sql = "insert into course values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.setString(2, cname);
			pstmt.setInt(3, fees);
			pstmt.setInt(4, dur_month);

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
	
	public boolean removeCourse() {
		try {
			String sql = "delete from course where cid=? and cname=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cid);
			
			pstmt.setString(2, cname);
			
			

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
