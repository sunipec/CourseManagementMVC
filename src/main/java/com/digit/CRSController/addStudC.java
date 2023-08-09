package com.digit.CRSController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.projectCRDModel.StudentModel;

@WebServlet("/addStud")
public class addStudC extends HttpServlet {

	

	 

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentModel asc = new StudentModel();
		PrintWriter writer=resp.getWriter();
		
		HttpSession session=req.getSession(true);
		
		asc.setSid(Integer.parseInt(req.getParameter("sid")));
		asc.setC_id(Integer.parseInt(req.getParameter("cid")));
		asc.setSname(req.getParameter("sname"));
		asc.setEmail(req.getParameter("email"));
		asc.setCname(req.getParameter("cname"));

		boolean x = asc.addStud();
		if (x == true) {
			session.setAttribute("sid", asc.getSid());
			session.setAttribute("cid", asc.getC_id());
			resp.sendRedirect("studentAddedSuccess.html");
			
		} else {
			
			resp.sendRedirect("addStudent.jsp");
		}
	}
}
