<%@page import="java.util.Iterator"%>
<%@page import="com.surabi.bean.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
<style>
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

table, th, td {
	border: 1px solid blue;
	padding: 5px;
	background-color: white;
}
</style>
</head>
<body>
	<%
	Object name = session.getAttribute("objName");
	%>
	<div align="center">
		<hr size="5px" color="black">
		<h1>SURABI RESTAURANT</h1>
		<hr size="5px" color="black">
		<h2><%=name%>
			Your Final Bill
		</h2>
	
	<%
	Object obj = session.getAttribute("objBill");
	List<Orders> listOfOrders = (List<Orders>) obj;
	if (!listOfOrders.isEmpty()) {
		Iterator ii = listOfOrders.iterator();
		float total = 0;
		String dateAndTime = null;
		int slNo = 1;
	%>

	<h3>Items You Have Ordered:</h3>
	<table>
		<tr>
			<th>Sl No.</th>
			<th>Item Number</th>
			<th>Item Name</th>
			<th>Number Of Plates</th>
			<th>Total Price Of Item</th>

		</tr>
		<%
		while (ii.hasNext()) {
			Object object = ii.next();
			Orders o = (Orders) object;
			dateAndTime = o.getKey().getDateAndTime();
			total += o.getTotalPrice();
		%>
		<tr>
			<td><%=slNo++%></td>
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
		Your Total Amount is= Rs.<%=total%>
	</h3>
	<h4>
		Date and Time :
		<%=dateAndTime%>
	</h4>

	<form action="/cart/deleteAllInCart" method="post">
		<input type="submit" value="Pay Amount" class="btn">

	</form>
	<%
	}
	%>
	</div>
</body>
</html>