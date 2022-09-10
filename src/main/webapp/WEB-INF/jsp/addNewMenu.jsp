<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Menu</title>

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
        
</style>
</head>
<body>
	<%
	Object result = request.getAttribute("objAddMenu");
	if (result != null) {
		out.print(result + "<br>");
	}
	%>
	<div align="right">
		<a href="/admin/adminLogout"><button class="btn">LOG OUT</button></a>
	</div>
	<div align="center">

		<hr size="5px" color="black">
		<h1>SURABI RESTAURANT</h1>
		<hr size="5px" color="black">
		<a href="/admin/adminHome"><button class="btn1">Home</button></a> <a
			href="/menu/displayMenuForAdmin"><button class="btn1">Menu</button></a> <a
			href="/menu/updateItemNamePage"><button class="btn1">Update Item Name</button></a>
		<a href="/menu/updateItemPricePage"><button class="btn1">Update Item
				Price</button></a> <a href="/menu/deleteItemPage" ><button class="btn1" >Delete
				Item</button></a>
	
	<h2>Add New Menu</h2>
	<form action="addNewMenu" method="post">
		<label >Item Id-----------------</label> <input type="text" name="id"
			required /><br>
		<br> <label>Item Name------------</label> <input type="text"
			name="name" required /><br>
		<br> <label>Item Price Per Plate--</label> <input type="text"
			name="price" required /><br>
		<br> <input type="submit" value="SUBMIT" class="btn1"> <input
			type="reset" value="RESET" class="btn1"> <br />
		<br />
	</form>
	</div>
</body>
</html>