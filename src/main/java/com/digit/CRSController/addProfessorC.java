package com.digit.CRSController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.projectCRDModel.ProfModel;

@WebServlet("/addProf")
public class addProfessorC extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ProfModel pfm=new ProfModel();
		PrintWriter writer=resp.getWriter();
		pfm.setCid(Integer.parseInt(req.getParameter("cid")));
		pfm.setPid(Integer.parseInt(req.getParameter("pid")));
		pfm.setPname(req.getParameter("pname"));
		pfm.setExp(Integer.parseInt(req.getParameter("exp")));
		

		boolean x = pfm.addProf();
		if (x == true) {
             session.setAttribute("pid", pfm.getPid());
             resp.sendRedirect("professorAddedSuccess.html");
		} else {
			
			resp.sendRedirect("addProf.html");
		}
		
	}
}
