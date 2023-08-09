package com.digit.CRSController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.projectCRDModel.adminModel;

@WebServlet("/Prof")
public class ProfAccC extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		adminModel adm = new adminModel();
		adm.setUser_name(req.getParameter("username"));
		adm.setPassword(req.getParameter("password"));

		boolean x = adm.createStudAcc();

		if (x == true) {
			writer.println("Professor Account Created Successfully");
			writer.println();
			resp.sendRedirect("addProf.jsp");
		} else {
			resp.sendRedirect("ProfAcc.html");
		}
	}
}
