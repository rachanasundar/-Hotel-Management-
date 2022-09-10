<%@page import="java.util.Iterator"%>
<%@page import="com.surabi.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All User</title>


<style type="text/css">
 body{
            background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPtEeqz8v5tvyZyejhnmp2TBxuIL1DkgwQUw&usqp=CAU");       
            background-repeat:repeat-x;
            font-family: "Arial";
            height: auto;
          
   		
        }

 .btn {
    white-space: normal !important;
     border-radius: 10px;
    background-color:lime;
    padding :10px;
}  
 .btn1 {
    white-space: normal !important;
     border-radius: 10px;
    background-color:rgb(69, 128, 238);
    padding :10px;
}  
  
        
</style>
<style>
table, th, td {
	border: 1px solid blue;
	padding: 5px;
	background-color: white;
	
}
</style>

</head>
<body>
	<div align="right">
		<a href="/admin/adminLogout"><button class="btn">LOG OUT</button></a>
	</div>
	<div align="center">
		<hr size="5px" color="black">
		<h1>SURABI RESTAURANT</h1>
		<hr size="5px" color="black">
		<a href="/admin/adminHome"><button class="btn1">Home</button></a> <a
			href="/user/addNewUserPage"><button class="btn1">Add New User</button></a> <a
			href="/user/updateUserPasswordPage"><button class="btn1">Update User
				Password</button></a> <a href="/user/deleteUserPage"><button class="btn1">Delete
				User</button></a> <a href="/orders/specificUserOrderPage"><button class="btn1">Orders
				Of A User</button></a>
	

	<h2>Users List</h2>
	<%
	Object users = request.getAttribute("objAllUser");
	List<String> listOfUser = (List<String>) users;
	if (listOfUser.isEmpty()) {
		out.print("No Users to display");
	} else {
		Iterator<String> ii = listOfUser.iterator();
		int slNumber = 1;
	%>
	<table>
		<tr>
			<th>SL NO.</th>
			<th>User Id</th>
		</tr>
		<%
		while (ii.hasNext()) {
			String userId = ii.next();
		%>
		<tr>
			<td><%=slNumber++%></td>
			<td><%=userId%></td>
		</tr>
		<%
		}
		%>

	</table>
	<%
	}
	%>
	</div>
</body>
</html>