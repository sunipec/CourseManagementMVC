package com.digit.CRSController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/viewMarks")
public class viewMarks extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session= req.getSession(true);
		
		int sid=(Integer.parseInt(req.getParameter("sid")));
		int cid=(Integer.parseInt(req.getParameter("cid")));
		String sname=req.getParameter("sname");
		
		
		session.setAttribute("cid", cid);
		session.setAttribute("sid", sid);
		
		resp.sendRedirect("showMarks.jsp");
		
		
	}
}
