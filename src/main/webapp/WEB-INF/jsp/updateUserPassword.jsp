<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
			href="/user/deleteUserPage"><button class="btn1">Delete User</button></a> <a
			href="/orders/specificUserOrderPage"><button class="btn1">Orders Of A
				User</button></a>
	
	<%
	Object result = request.getAttribute("objUpdatePass");
	if (result != null) {
		out.print(result + "<br>");
	}
	%>

	<h2>Update User Password</h2>
	<form action="updatePassword" method="post">
		<label> E-Mail ID</label> <input type="email" name="email" required>
		<br />
		<br /> <label>Password </label> <input type="password" name="password"
			required><br />
		<br /> <input type="submit" value="UPDATE" class="btn2"> <input
			type="reset" value="RESET" class="btn2"> <br />
		<br />
	</form>
	</div>
</body>
</html>