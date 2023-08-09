package com.digit.CRSController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.projectCRDModel.ProfModel;

@WebServlet("/removeP")
public class removeProfC extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProfModel pfm=new ProfModel();
		PrintWriter writer=resp.getWriter();
		pfm.setPid(Integer.parseInt(req.getParameter("pid")));
		pfm.setPname(req.getParameter("pname"));
		
		boolean x=pfm.removeProf();
		
		if (x == true) {

			writer.println("Professor  Removed Succesfully");
		} else {
			
			resp.sendRedirect("removeProf.html");
		}
	}
}
