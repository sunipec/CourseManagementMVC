package com.digit.CRSController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.projectCRDModel.adminModel;



@WebServlet("/admin")
public class adminLoginC extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		  
		 adminModel adm = new adminModel();
		  adm.setUser_name(req.getParameter("username"));
		  adm.setPassword(req.getParameter("password"));
		  
		  boolean x=adm.loginA();
		  if(x==true) {
			 
			  resp.sendRedirect("/courseManagementJdbcServletMVC/adminServices.html");
		  }
		  else {
			 

			  resp.sendRedirect("/courseManagementJdbcServletMVC/indexA.html");
		  }
	}

	
}
