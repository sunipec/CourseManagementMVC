package com.digit.CRSController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.projectCRDModel.adminModel;

@WebServlet("/Stud")
public class studAcc extends HttpServlet {

	private PrintWriter writer;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		writer=resp.getWriter();
		adminModel adm=new adminModel();
		adm.setUser_name(req.getParameter("user_name"));
		adm.setPassword(req.getParameter("password"));
		
		
		boolean x=adm.createStudAcc();
		
		if(x==true) {
			
			resp.sendRedirect("addStudent.jsp");
		}
		else {
			resp.sendRedirect("StudAcc.html");
		}
	}
}
