package com.digit.projectCRDModel;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class adminModel  {

	String user_name;
	String password;
	private Connection con;
	private PreparedStatement pstmt;
	public ResultSet res;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public adminModel() {
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
	
	public boolean loginA() {
		
		try {
			
			String sql="select * from users where user_name=? and password=?";
			
			
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, user_name);
			 pstmt.setString(2, password);
			  res = pstmt.executeQuery();
			  
			  while(res.next()==true) {
			   if(user_name.equals(res.getString("user_name")) && password.equals(res.getString("password"))) {
				  
				  return true;
			  }
			  else {

				  return false;
			  }
			  }   
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
		 
	}
	
	public boolean createStudAcc() {
		try {
			
			String sql = "insert into users values(?,?)";

			

				pstmt =con.prepareStatement(sql);

				pstmt.setString(1, user_name);

				pstmt.setString(2, password);

				int x = pstmt.executeUpdate();

				if (x > 0) {
					return true;
				}
				else {
					return false;
				}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	

}
