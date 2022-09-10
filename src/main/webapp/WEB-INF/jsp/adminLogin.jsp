<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Log In</title>

<style type="text/css">
 body{
            background-image: url("https://media.gettyimages.com/vectors/illustration-of-a-group-of-people-eating-outdoors-at-a-restaurant-vector-id1285195940?k=20&m=1285195940&s=612x612&w=0&h=rtDPS2a4dR-Z4m9JGaTpOyaWE1V8IXEmiVHwjtF3PGI=");
            background-repeat:inherit;
            font-family: "Arial";
            height: auto;
   		
        }

 .btn {
    white-space: normal !important;
     border-radius: 10px;
    background-color:lime;
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
	<div align="center">
		<hr size="5px" color="black">
		<h1>SURABI RESTAURANT</h1>
		<hr size="5px" color="black">
	
	<h2>
		Welcome Admin!<br>
	</h2>
	<h3>Please Log in to Proceed</h3>
	<form action="/admin/adminLogin" method="post">
		<label> E-Mail ID</label> <input type="email" name="email" required />
		<br />
		<br /> <label>Password </label> <input type="password" name="password"
			required><br />
		<br /> <input type="submit" value="SUBMIT" class ="btn"> <input
			type="reset" value="RESET" class ="btn"> <br />
		<br />

	</form>
	</div>
</body>
</html>