<%@page import="java.util.Iterator"%>
<%@page import="com.surabi.bean.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Orders</title>
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

  .btn2{
    white-space: normal !important;
     border-radius: 10px;
    background-color:aqua;
    padding :10px;
}  
        
</style>
<style>
table, th, td {
	border: 1px solid blue;
	padding: 5px;
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
			href="/user/displayAllUser"><button class="btn1">View All User</button></a> <a
			href="/user/addNewUserPage"><button class="btn1">Add New User</button></a> <a
			href="/user/updateUserPasswordPage"><button class="btn1">Update User
				Password</button></a> <a href="/user/deleteUserPage"><button class="btn1">Delete
				User</button></a>

	</div>
<div align="center">
	<h2>Find All Orders of A User</h2>
	<form action="/orders/specificUserOrder" method="post">
		<label> E-Mail ID</label> <input type="email" name="email" required>
		<br />
		<br /> <input type="submit" value="SUBMIT" class="btn2"> <input
			type="reset" value="RESET" class="btn2"> <br />
		<br />
	</form>
	
	<%
Object obj= request.getAttribute("objSpecificUserOrder");
Object obj2= request.getAttribute("fromSubmitted");
if(obj!=null){
		List<Orders> listOfOrder =(List<Orders>)obj;
		if(listOfOrder.isEmpty()){
			out.print("<h4>No orders to display</h4>");
		}
		else{

			Iterator<Orders> ii = listOfOrder.iterator();
			int slNo=1;
			%>
	<h2>Items User Have Ordered in Past:</h2>
	<table>
		<tr>
			<th>Sl No.</th>
			<th>Date And Time</th>
			<th>User Id</th>
			<th>Item Number</th>
			<th>Item Name</th>
			<th>Number Of Plates</th>
			<th>Total Price Of Item</th>

		</tr>
		<%
					while(ii.hasNext()){
						Object object = ii.next();
						Orders o = (Orders) object;
						
		%>
		<tr>
			<td><%=slNo++ %></td>
			<td><%=o.getKey().getDateAndTime() %></td>
			<td><%=o.getKey().getEmail() %></td>
			<td><%=o.getKey().getItemId() %></td>
			<td><%=o.getItemName() %></td>
			<td><%= o.getNumberOfPlate()%></td>
			<td><%=o.getTotalPrice()%></td>
		</tr>
		<%
					}
		%>
	</table>
	<%
			
		}
			
		}


	%>

</div>
</body>
</html>