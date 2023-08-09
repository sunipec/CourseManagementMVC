package com.digit.CRSController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.digit.projectCRDModel.adminModel;

@WebServlet("/stud")
public class studLoginC extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		adminModel stm = new adminModel();
		
		  stm.setUser_name(req.getParameter("username"));
		  stm.setPassword(req.getParameter("password"));
		  
		  boolean x=stm.loginA();
		  if(x==true) {
			 
			  resp.sendRedirect("/courseManagementJdbcServletMVC/StudentServices.html");
		  }
		  else {
			 

			  resp.sendRedirect("/courseManagementJdbcServletMVC/indexS.html");
		  }
		
	}
}
