<%@page import="java.util.Iterator"%>
<%@page import="com.surabi.bean.MyCart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
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
    background-color:red;
    padding :5px;
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

	<%Object name = session.getAttribute("objName");
	
	Object result = request.getAttribute("objDelete");
	if(result!=null){
	out.print("<br>"+result);
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
			href="/menu/displayMenuForUser"><button class="btn1">Menu</button></a> <a
			href="/order/userOldOrders"><button class="btn1">My Orders</button></a><br>
			<div class ="div">
		<h2>
			<%=name %>'s Cart
		</h2></div>
<%
Object cartList= request.getAttribute("objCart");

Object total = request.getAttribute("objTotal");

if(cartList==null){
	out.print("<br/><h3>Your Cart is Empty <h3>");
}
else{
	List<MyCart> listOfItems = (List<MyCart>)cartList;
	if(listOfItems.isEmpty()){
		out.print("<br/><h3>Your Cart is Empty <h3>");
	}
	else{
		out.print("<br/><h3>Your Cart<h3>");
		Iterator<MyCart> ii = listOfItems.iterator();
		int slNo=1;
		
		%>

	<h2>Items In Your Cart:</h2>
	<table>
		<tr>
			<th>Sl No.</th>
			<th>Item Number</th>
			<th>Item Name</th>
			<th>Number Of Plates</th>
			<th>Total Price Of Item</th>
			<th>Remove</th>
		</tr>

		<%
			while(ii.hasNext()){
				MyCart cart = ii.next();
				%>
		<tr>
			<td><%=slNo++ %></td>
			<td><%=cart.getKey().getItemId() %></td>
			<td><%=cart.getItemName() %></td>
			<td><%= cart.getNumberOfPlates()%></td>
			<td><%=cart.getTotalPrice() %></td>
			<td>
				<form action="deleteItem" method="post">
					<input type="hidden" name="id"
						value="<%=cart.getKey().getItemId() %>" /> <input type="submit"
						value="Delete" class="btn2">
				</form>
			</td>
		</tr>

		<%
				
			}
		
		
		%>

	</table>
	<div class ="div">
	<h3>
		Your Total Amount is= Rs.<%=total %>
	</h3></div>


	<form action="/order/generateBill" method="post">
		<%session.setAttribute("objCartList", cartList);  %>
		<input type="submit" value="Generate Bill" class="btn">
	</form>


	<%
	}
}
%>
</div>
</body>
</html>