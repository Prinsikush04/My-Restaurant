 <%@page import="order.dto.OrderDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<% 
OrderDTO o = (OrderDTO)request.getAttribute("OrderDTO");
Double t = (Double)request.getAttribute("tprice");
            if(o!=null)
            {
            	%>
            	
            	
            	<div class="order">
            	<h2>Order Now<h2>
            	<form action="order.jsp" method="post"> 
                Enter itemId :
             <input type="text" name="item_id" value="<%=o.getItem_id()%>"><br><br> 
              Enter itemName :
             <input type="text" name="name" value="<%=o.getName() %>"><br><br> 
              Enter quantity :
              <input type="text" name="quantity" value="<%=o.getQuantity()%>"><br><br>
              
              <input type="Submit" value=" more Order" name="b1"><br><br>
              
              <center>
              Per unit price:
              <input type="text" name="price" value="<%=o.getPrice()%>">
              Total price :
               <input type="text" name="total_price" value="<%=t%>">
                
              </center>
              
           </form>
           <a href="index.jsp" >Go to Home</a>
           <% }
            	%>
            	</div>
</body>
</html>