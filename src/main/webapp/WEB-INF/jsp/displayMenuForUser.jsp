<%@page import="java.util.Iterator"%>
<%@page import="com.surabi.bean.Menu"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu For User</title>
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
 .btn2 {
    white-space: normal !important;
     border-radius: 5px;
    background-color:green;
    padding :5px;
} 
        
</style>
<style>
table, th, td {
	border: 1px solid blue;
	padding: 5px;
	background-color: white;
}

input[type=number] {
	width: 80px;
	align-self: center;
}
.div{
background-color: white;}
</style>
</head>
<body>
	<%
Object order=request.getAttribute("objSelect");
Object name = session.getAttribute("objName");
if(order!=null){
	out.print(order+"<br>");
}
%>
	<div align="right">

		<a href="/user/userlogout"><button class="btn">LOG OUT</button>
			<br></a>
	</div>
	<div align="center">
		<hr size="5px" color="black">
		<h1>SURABI RESTAURANT</h1>
		<hr size="5px" color="black">
		<a href="/user/userHome"><button class="btn1">HOME</button></a> <a
			href="/cart/userCart"><button class="btn1">My Cart</button></a> <a
			href="/order/userOldOrders"><button class="btn1">My Orders</button></a><br>
	<div class ="div">
	<H2> 
		Today's Menu For <%=name %>
		
	</H2></div>
	<%Object menu = session.getAttribute("objMenu");

List<Menu> listOfMenu = (List<Menu>)menu;

if(listOfMenu.isEmpty()){
	out.print("<h4>No Menu to display</h3>");
}else{
	out.print("<h4>Order ONE at a time</h3>");
	Iterator<Menu> ii = listOfMenu.iterator();
%>
	<table>
		<tr>
			<th>Item ID</th>
			<th>Item Name</th>
			<th>Item Price Per Plate</th>
			<th>Number of Plates</th>
			<th>Select</th>

			<th>Add to Cart</th>

		</tr>

		<%
	 		while (ii.hasNext()){
	 			Menu item = ii.next();
	 			
%>
		<tr>
			<td><%=item.getItemId() %></td>
			<td><%=item.getItemName() %></td>
			<td><%= item.getItemPrice()%></td>

			<form action="/cart/order" method="post">
				<td><input type="number" min="1" value="1"
					name="numberOfPlates"></td>
				<td><input type="checkbox" value="select" name="item">
					<input type="hidden" value="<%=item.getItemId() %>" name="id">
					<input type="hidden" value="<%=item.getItemName() %>" name="name">
					<input type="hidden" value="<%= item.getItemPrice()%>" name="price">
				</td>
				<td><input type="submit" value="Order" class="btn2"/></td>
			</form>
		</tr>

		<%
	 		}
	 
%>

	</table>
	<br>
	<a href="/cart/userCart"><button class="btn1">---View Cart---</button></a>

	<%
	
}
%>
</div>
</body>
</html>