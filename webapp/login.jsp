<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration</title>
<link rel="stylesheet" href="login.css">


</head>
<body>
<center> 
<%
String msg = (String) request.getAttribute("msg");
if(msg!=null)
{
	out.print(msg);
}
%>
<h1>Registration</h1>
<br><br>
<form action="LoginServlet" method="post"> 
<pre>Name      :<input type="text" placeholder="Enter Name" name="t1" required="required"></pre>
<br>
<pre>Contact NO:<input type="text" placeholder="Enter Contact" name="t2"  required="required"></pre>
 <br>
<pre>Email     :<input type="email" placeholder="Email Address" name="t3" data-error="E-mail id is required."  required="required"></pre>
 <br>
 <input  type="Submit"  value="Registration" name="b1" >
 </form> 
 
</center>
</body>
</html>

