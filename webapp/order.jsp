 <%@page import="order.dto.OrderDTO"%>
 <%@page import="order.dbs.OrderDBS" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Order</title>
<style>
body{
background:url('food.jpg');
height:100%;
 width:100%;
 background-repeat:no-repeat;
 background-size:cover;
  z-index:-5;
  display:flex;
  justify-content:center;
  text-align:center;
}
 

</style>
</head>
<body>
<div class="oder">
<h2>
Order Now
</h2>
 
<br>
 
<form action="OrderServlet" method="post"> 
   Enter itemId     :
  <input type="text" name="item_id"><br><br> 
   Enter itemName   :
  <input type="text" name="name"  ><br><br> 
   Enter quantity   :
   <input type="text" name="quantity"><br><br>
   
   <input type="Submit" value="Order" name="b1"><br><br>
    
    <center>
   Per unit price:
   <input type="text" name="price"  >
   Total price :
    <input type="text" name="total_price" >
     </center>
     
   
</form>
<a href="index.jsp">Go to home page</a>
  </div>
 
</body>
</html>