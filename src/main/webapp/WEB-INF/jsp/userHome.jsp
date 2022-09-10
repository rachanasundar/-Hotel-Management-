<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>

<style type="text/css">
 body{
            background-image: url("https://media.gettyimages.com/vectors/illustration-of-a-group-of-people-eating-outdoors-at-a-restaurant-vector-id1285195940?k=20&m=1285195940&s=612x612&w=0&h=rtDPS2a4dR-Z4m9JGaTpOyaWE1V8IXEmiVHwjtF3PGI=");
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
</head>
<body>
	<%
	Object loginResult = request.getAttribute("objLogInResult");
	Object name = session.getAttribute("objName");
	if (loginResult != null) {
		out.print(loginResult);
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
		<h2>
			Welcome
			<%=name%></h2>
		<a href="/menu/displayMenuForUser"><button class="btn1">Menu</button></a> <a
			href="/cart/userCart"><button class="btn1">My Cart</button></a> <a
			href="/order/userOldOrders"><button class="btn1">My Orders</button></a><br>
		<%
		Object bill = request.getAttribute("objOrder");
		if (bill != null) {
			out.print("<h3>" + bill + "</h3>");
		%>
		<a href="/order/getBill"><button class="btn1">View Bill</button></a>
		<%
		}
		Object amount = request.getAttribute("objAmount");
		if (amount != null) {
		out.print("<h3>" + amount + "</h3>");
		}
		%>
	
</body>
</html>