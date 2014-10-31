<%/* if (request.getSession().getAttribute("sessionId") != null) {
	response.sendRedirect(".");
	}*/%>
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
    	</ul>
    </nav>	
</nav>

<!-- Body -->
<div class="grid" style="margin-left:2%;margin-top:5%">
	<form method="post" action="doLogin" >
		<input type="password" name="pass">
	</form>
</div>

</body>
<script type="text/javascript">
		var secret = "38384040373937396665"; 
		var input = "";
		var timer;
		
		$(document).keyup(function(e) {
		   input += e.which;    
		   clearTimeout(timer);
		   timer = setTimeout(function() { input = ""; }, 3000);
		   check_input();
		});
		
		function check_input() {
		    if(input == secret) {
		    	alert("You can't cheat your way out of this :P\nNice try though.");           
		    }
		};
</script>

</html>