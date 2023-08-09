<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.Connection"%>

<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Student ScoreCard</h3>

	<table>
		<tr>
			<th>Student ID</th>
			<th>Course ID</th>
			<th>Student Name</th>
			<th>Course Name</th>
			<th>Marks</th>
			
		</tr>

	<%
	session = request.getSession();
	int cid = (int) session.getAttribute("cid");
	int sid = (int) session.getAttribute("sid");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		String url = "jdbc:mysql://localhost:3306/crsmvc";
		String user = "root";
		String pwd = "1234";

		Connection con = DriverManager.getConnection(url, user, pwd);

		String sql = "select * from student where sid=? and cid=?";

		PreparedStatement psta = con.prepareStatement(sql);

		psta.setInt(1, sid);
		psta.setInt(2, cid);
		ResultSet res5 = psta.executeQuery();

		while (res5.next() == true) { %>
		
		<tr>
			<td><%= res5.getInt(1)  %></td>
			<td><%= res5.getInt(2) %></td>
			<td><%= res5.getString(3) %></td>
			<td><%= res5.getString(5) %></td>
			<td><%= res5.getInt(6) %></td>
			
			
			</tr>
		
		</table>
	<% 	}
	} catch (Exception e) {
		out.println("Marks can not be viewed.");
	}
	%>

</body>
</html>