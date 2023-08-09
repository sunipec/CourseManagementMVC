package com.digit.CRSController;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.projectCRDModel.StudentModel;

@WebServlet("/grade")
public class gradeStud extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		StudentModel sm=new StudentModel();	
		sm.setSid( Integer.parseInt(req.getParameter("sid")));
		sm.setSname(req.getParameter("sname"));
		int marks=Integer.parseInt(req.getParameter("marks"));
		
		boolean x=sm.gradeStudent(marks);
		
		if(x==true) {
			resp.sendRedirect("studentGradedSuccess.html");
		}
		else {
			writer.println("Stduent Not Graded Yet");
			resp.sendRedirect("gradeStud.jsp");
		}
		
	}
}
