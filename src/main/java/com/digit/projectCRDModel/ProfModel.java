package com.digit.projectCRDModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProfModel {
	int pid;
	int cid;
	String pname;
	int exp;
	private Connection con;
	private PreparedStatement pstmt;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public ProfModel() {
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver loaded");
			  String url="jdbc:mysql://localhost:3306/crsmvc";
			  String user="root";
				String pwd="1234";
				
				//Step 2
				 con = DriverManager.getConnection(url,user,pwd);
		         System.out.println("Connection created");
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
	}
	
	public boolean addProf() {
		try {
			String sql = "insert into professors values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setInt(2, cid);
			pstmt.setString(3, pname);
			pstmt.setInt(4, exp);
			

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
	
	public boolean removeProf() {
		try {
			String sql = "delete from professors where pid=? and pname=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pid);
			
			pstmt.setString(2, pname);
			
			

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
