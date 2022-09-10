
<%@page import="java.util.Iterator"%>
<%@page import="com.surabi.bean.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>
<style type="text/css">
body{
           
        background-image: url("https://media.gettyimages.com/vectors/place-setting-drawing-vector-id524154166?k=20&m=524154166&s=612x612&w=0&h=qMQBcP6WU9chIDxKT5AJULXw1QXgDMIadQHHlIdFwxk=");
       background-repeat:no-repeat;
       background-position: center;
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

table, th, td {
	border: 1px solid blue;
	padding: 5px;
	background-color: white;
}
.div{
background-color: white;}
</style>

</head>
<body>
	<div align="right">

		<a href="/user/userlogout"><button class="btn">LOG OUT</button>
			<br></a>
	</div>
	<div align="center">
		<hr size="5px" color="black">
		<h1>SURABI RESTAURANT</h1>
		<hr size="5px" color="black">
		<a href="/user/userHome"><button class="btn1">HOME</button></a>
		 <a	href="/cart/userCart"><button class="btn1">My Cart</button></a>
		 <a href="/menu/displayMenuForUser"><button class="btn1">Menu</button></a>

	

	<%Object name = session.getAttribute("objName");
	
	Object obj = request.getAttribute("objAllOrder");
	List<Orders> listOfOrder = (List<Orders>) obj;
	if (listOfOrder.isEmpty()) {
		out.print("<h3>No Orders to display</h3>");
	} else {
		Iterator<Orders> ii = listOfOrder.iterator();
		int slNo = 1;
	%>
	<div class ="div">
	<h2> Items <%=name %> Have Ordered in Past:</h2></div>
	<table>
		<tr>
			<th>Sl No.</th>
			<th>Date And Time</th>
			<th>Item Number</th>
			<th>Item Name</th>
			<th>Number Of Plates</th>
			<th>Total Price Of Item</th>

		</tr>
		<%
		while (ii.hasNext()) {
			Object object = ii.next();
			Orders o = (Orders) object;
		%>
		<tr>
			<td><%=slNo++%></td>
			<td><%=o.getKey().getDateAndTime()%></td>
			<td><%=o.getKey().getItemId()%></td>
			<td><%=o.getItemName()%></td>
			<td><%=o.getNumberOfPlate()%></td>
			<td><%=o.getTotalPrice()%></td>
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