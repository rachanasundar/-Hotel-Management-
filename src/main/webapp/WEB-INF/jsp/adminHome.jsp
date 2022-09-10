<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>


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
	if (loginResult != null) {
		out.print(loginResult);
	}
	%>
	<div align="right">
		<a href="/admin/adminLogout"><button class="btn">LOG OUT</button></a>
	</div>
	<div align="center">
		<hr size="5px" color="black">
		<h1>SURABI RESTAURANT</h1>
		<hr size="5px" color="black">
		<h2>Admin Home page</h2>
	</div>

	<hr>

	<h3 >Menu</h3>
	<a href="/menu/displayMenuForAdmin"><button class="btn1">Menu</button ></a>
	<a href="/menu/addNewMenuPage"><button class="btn1">Add New Menu</button></a>
	<a href="/menu/updateItemNamePage"><button class="btn1">Update Item
			Name</button></a>
	<a href="/menu/updateItemPricePage"><button class="btn1">Update Item
			Price</button></a>
	<a href="/menu/deleteItemPage"><button class="btn1">Delete Item</button></a>
	<hr>

	<h3>User</h3>
	<a href="/user/displayAllUser"><button class="btn1">View All User</button></a>
	<a href="/user/addNewUserPage"><button class="btn1">Add New User</button></a>
	<a href="/user/updateUserPasswordPage"><button class="btn1">Update User
			Password</button></a>
	<a href="/user/deleteUserPage"><button class="btn1">Delete User</button></a>
	<a href="/orders/specificUserOrderPage" ><button class="btn1">Orders Of
			A User</button></a>

	<hr>

	<h3>Orders</h3>
	<a href="/orders/displayTodaysBills"><button class="btn1">Today's
			Orders</button></a>
	<a href="/orders/displayMonthlyBills"><button class="btn1">This Month's
			Orders</button></a>
	
	<hr>
</body>
</html>