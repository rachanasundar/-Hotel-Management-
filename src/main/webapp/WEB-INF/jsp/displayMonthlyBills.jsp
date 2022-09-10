<%@page import="java.util.Iterator"%>
<%@page import="com.surabi.bean.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This Month's Bills</title>
<style type="text/css">
 body{
            background-image: url("https://media.gettyimages.com/vectors/receipt-icon-design-vector-id1145854519?k=20&m=1145854519&s=612x612&w=0&h=N5_XTKiQToQY8C2HOxUptWo9mN_ka5BAWYwkgWfSuC0=");
            background-repeat:inherit;
            font-family: "Arial";
            height: 100%;
   		
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
			href="/orders/displayTodaysBills"><button class="btn1">Today's Orders</button></a>

		
	

	<h2>This Month's Orders</h2>
	<%
	Object obj = request.getAttribute("objMonthyOrder");
	List<Orders> listOfOrders = (List<Orders>) obj;
	if (listOfOrders.isEmpty()) {
		out.print("<h2>No Orders This Month</h2>");
	} else {
		Iterator ii = listOfOrders.iterator();
		float total = 0;
		int slNo = 1;
	%>
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
		while (ii.hasNext()) {
			Object object = ii.next();
			Orders o = (Orders) object;
			total += o.getTotalPrice();
		%>

		<tr>
			<td><%=slNo++%></td>
			<td><%=o.getKey().getDateAndTime()%></td>
			<td><%=o.getKey().getEmail()%></td>
			<td><%=o.getKey().getItemId()%></td>
			<td><%=o.getItemName()%></td>
			<td><%=o.getNumberOfPlate()%></td>
			<td><%=o.getTotalPrice()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<h3>
		Total Sales For This Month= Rs.<%=total%>
	</h3>
	<%
	}
	%>
</div>
</body>
</html>