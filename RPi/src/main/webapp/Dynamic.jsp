<% if (request.getSession().getAttribute("sessionId") == null) {
	response.sendRedirect("./Login");
	}%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		
        <link rel="stylesheet" href="BootstrapMetro/docs/css/metro-bootstrap.css">
        <script src="BootstrapMetro/docs/js/jquery/jquery.min.js"></script>
        <script src="BootstrapMetro/docs/js/jquery/jquery.widget.min.js"></script>
        <script src="BootstrapMetro/min/metro.min.js"></script>
        <link rel="shortcut icon" href="images/remote_control.ico" />
	    <title>SuperRemotely</title>

</head>
<body class="metro">
<div class="container">
<!-- Header -->
<nav class="navigation-bar dark fixed-top">
	<nav class="navigation-bar-content">
        <ul class="element-menu">
        	<li><a href="/RPi">Home</a></li>
        	<li><a href="./Devices">Devices</a></li>
        	<li><a href="./Action">Actions</a></li>
        	<li><a href="./Sequence">Sequences</a></li>
        	<li><a href="./Alarm">Alarm</a></li>
        	<li>
                <a class="dropdown-toggle" href="#Options">Options</a>
                <ul class="dropdown-menu dark" data-role="dropdown" style="display: none;">
                	<li><a href="#Time">Set the time</a></li>
                    <li><a href="#Pass">Change your password</a></li>
                </ul>
            </li>
            <li><a href="./Logout">Logout</a>
            <li><a class="element place-right" href="#"><div class="times" data-role="times" style="font-size:100%"></div></a></li>
    	</ul>
    </nav>	
</nav>

<!-- Body -->

<div class="grid" style="margin-left:1%;margin-top:3%">
	<%@ page import="java.util.*"%>
	<%
		int elem = 0;
		if (request.getAttribute("actionList") != null) {	

			Map<Integer, String> actions = (Map<Integer, String>) request.getAttribute("actionList");
			if (actions.size() == 0) {
				
			} else {
	%>
	<form method="post" action="doAction">
	<input type="hidden" name="url" value="/Dynamic.jsp">
	<div class="grid">
	<%
				for (Map.Entry<Integer, String> e : actions.entrySet()) {
	%>
						<div class="row" >
						<div class="span1">
						ID:<a name="actId" ><%= e.getKey() %></a>
						</div>
						<div class="span1">
						Name: <a name="actNam"><%= e.getValue() %></a>
						</div>
						<div class="span1">
						<input class="bg-lightBlue bg-hover-darkBlue fg-white" type="submit" name="button" value="Remove">
						</div>
						<div class="span1">
						<input class="bg-lightBlue bg-hover-darkBlue fg-white" type="submit" name="button" value="Execute">
						<input type="hidden" name="actId" value="<%=e.getKey() %>">
						<input type="hidden" name="actIdexe" value="<%=e.getKey() %>">
						</div>
						</div>
						</form>
	<% }}} else if (request.getAttribute("deviceList") != null) { 
			Map<Integer, String> devices = (Map<Integer, String>) request.getAttribute("deviceList");
			if (devices.size() == 0) {
				
			} else {
	%>
				<form method="post" action="doAction">
				<input type="hidden" name="url" value="/Dynamic.jsp">
				<div class="grid">
	<%
				for (Map.Entry<Integer, String> e : devices.entrySet()) {
	%>
					<div class="row" >
					<div class="span1">
					ID:<a name="actId" ><%= e.getKey() %></a>
					</div>
					<div class="span1">
					Name: <a name="actNam"><%= e.getValue() %></a>
					</div>
					<div class="span1">
					<input class="bg-lightBlue bg-hover-darkBlue fg-white" type="submit" name="button" value="Remove">
					</div>
					<div class="span1">
					<input class="bg-lightBlue bg-hover-darkBlue fg-white" type="submit" name="button" value="Execute">
					<input type="hidden" name="actId" value="<%=e.getKey() %>">
					<input type="hidden" name="actIdexe" value="<%=e.getKey() %>">
					</div>
					</div>
					</form>
	<% }}}
	%>
</div>
</div>
</body>
</html>