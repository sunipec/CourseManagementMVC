<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.Statement"%>

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
	<h3>Student List</h3>

	<table>
		<tr>

			<th>Student ID</th>
			<th>Student Name</th>

			<th>Course Name</th>
			<th>Professor Name</th>



		</tr>
<!-- ////-->
		<%
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			String url = "jdbc:mysql://localhost:3306/crsmvc";
			String user = "root";
			String pwd = "1234";

			Connection con = DriverManager.getConnection(url, user, pwd);

			String sql = "select student.sid, student.sname, student.cname, professors.pname from student left join professors on student.cid=professors.cid ";

			Statement psta = con.createStatement();

			ResultSet res5 = psta.executeQuery(sql);

			while (res5.next() == true) {
		%>

		<tr>

			<td><%=res5.getInt("sid")%></td>
			<td><%=res5.getString("sname")%></td>
			<td><%=res5.getString("cname")%></td>
			<td><%=res5.getString("pname")%></td>


		</tr>

		<%
		}

		} catch (Exception e) {
		out.println("Operation  can not be viewed");
		}
		%>
	</table>
	<div class="container">
		<form action="grade">
			<h6>Enter Student Details you wanted to Grade</h6>
			<br>
			<br> <label>Student Id </label><br> <input type="text"
				name="sid"><br>
			<br> <label>Student Name </label><br> <input type="text"
				name="sname"><br>
			<br>
			<label>Enter Marks </label><br> <input type="text"
				name="marks"><br><br>
			
			<input type="submit" value="Grade">

		</form>
	</div>
</body>
</html>