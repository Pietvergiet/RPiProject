<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="coreservlets.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayPage</title>
</head>
<body BGCOLOR="#FDF5E6">
	<H1 ALIGN = "CENTER">Pay Page</H1>
	<%! ShoppingCart cart; %>
	<% cart = ((ShoppingCart) (request.getSession().getAttribute("shoppingCart"))); %>
	<p>Thank you for paying: $ <%= cart.getTotalCost() %> </p>
	<form action="Welcome.html">
    <input type="submit" value="Return to home">
    <% cart.emptyCart(); %>
	</form>
	

</body>
</html>