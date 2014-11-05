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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
	    <title>SuperRemotely</title>

</head>
<body class="metro">
<!-- Header -->
<nav class="navigation-bar dark shadow">
<div class="navbar-header">
                <div class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">          
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </div>
                </div>
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
                    <li><a href="#Record">Record new action</a></li>
                    <li><a href="#Add">Add a new Device</a></li>
                    <li><a href="#Remove">Remove a device</a></li>
                    <li><a href="#Edit">Remove an action</a></li>
                </ul>
            </li>
            <li><a href="./Logout">Logout</a>
            <li><a class="element place-right" href="#"><div class="times" data-role="times" style="font-size:100%"></div></a></li>
    	</ul>
    </nav>	
</nav>

<!-- Body -->
<div class="container">
<div class="grid" style="margin-left:2%;margin-top:5%">
<img src="http://www.toeters.net/judith.toeters/beeld/welkom.gif" class="img-polaroid">
</div>
</div>
</div>
</body>
</html>