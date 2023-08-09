package com.digit.CRSController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.digit.projectCRDModel.courseModel;

@WebServlet("/addCourse")
public class addCourse extends HttpServlet {
	
	private PrintWriter writer;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		courseModel csm = new courseModel();
		csm.setCid(Integer.parseInt(req.getParameter("courseId")));
		csm.setCname((req.getParameter("courseName")));
		csm.setFees(Integer.parseInt(req.getParameter("courseFee")));
		csm.setDur_month(Integer.parseInt(req.getParameter("courseDur")));
		
		boolean x=csm.addCourse();
		
		   writer = resp.getWriter();
		
		if(x==true) {
			session.setAttribute("cname", csm.getCname());
			session.setAttribute("CourseId", csm.getCid());
			resp.sendRedirect("courseAddedSuccess.html");
			
			
		}
		else {
			writer.println("Course is Not  Added Yet");
			resp.sendRedirect("addCourse.html");
		}
				

	}

}
