package com.digit.CRSController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.projectCRDModel.ProfModel;
import com.digit.projectCRDModel.StudentModel;

@WebServlet("/removeS")
public class RemoveStudC  extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentModel sm = new StudentModel();
		PrintWriter writer=resp.getWriter();
		sm.setSid(Integer.parseInt(req.getParameter("sid")));
		sm.setSname(req.getParameter("sname"));
		
		boolean x=sm.removeStud();
		
		if (x == true) {

			writer.println("Student  Removed Succesfully");
		} else {
			
			resp.sendRedirect("removeStud.html");
		}
	}
}
