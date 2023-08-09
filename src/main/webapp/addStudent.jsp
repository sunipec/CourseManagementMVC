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
<h2>Student Account Created Successfully</h2><br>

<h3>Course Details </h3>

<table>
<tr>
	<th>Course Id </th>
	<th>Course Name </th>
	<th>Fees </th>
	<th>Course Duration </th>
</tr>

<%
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			String url = "jdbc:mysql://localhost:3306/crsmvc";
			String user = "root";
			String pwd = "1234";

			Connection con = DriverManager.getConnection(url, user, pwd);

			String sql = "select * from course";

			Statement psta = con.createStatement();

			ResultSet res5 = psta.executeQuery(sql);

			while (res5.next() == true) {
		%>

		<tr>

			<td><%=res5.getInt(1)%></td>
			<td><%=res5.getString(2)%></td>
			<td><%=res5.getInt(3)%></td>
			<td><%=res5.getInt(4)%></td>


		</tr>

		<%
		}

		} catch (Exception e) {
		out.println("Operation  can not be viewed");
		}


%>



</table><br><br>

<h3>Enter Student Details and Course Student want</h3>

<form action="addStud">
	  
	  <label>Student Id </label><br>
	 <input type="text" name="sid"><br><br>
	 <label>Student Name </label><br>
	  <input type="text" name="sname"><br><br>
	 <label>Course Id </label><br>
	  <input type="text" name="cid"><br><br>
	 
	 <label>Course Name </label><br>
	  <input type="text" name="cname"><br><br>
	  <label>Email  </label><br>
	  <input type="text" name="email"><br><br>
	  
	  <input type="submit" value="Add Student">
  </form>





</body>
</html>