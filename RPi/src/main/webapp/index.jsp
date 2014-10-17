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
	
	    <!-- Metro UI CSS JavaScript plugins -->
	    

</head>
<body class="metro">

<div class="navigation-bar dark fixed-top shadow">
        <ul class="element-menu">
        	<li><a href="/RPi">Home</a></li>
        	<li>
                <a class="dropdown-toggle" href="#Options">Options</a>
                <ul class="dropdown-menu dark" data-role="dropdown" style="display: none;">
                    <li><a href="#Add">Add a device</a></li>
                    <li><a href="#Remove">Remove a device</a></li>
                    <li><a href="#Edit">Edit a device</a></li>
                </ul>
            </li>
            <li>
                <a class="dropdown-toggle" href="#Devices">Devices</a>
                <ul class="dropdown-menu dark" data-role="dropdown" style="display: none;">
                    <li><a href="#Tv">Tv</a></li>
                    <li><a href="#DVD">DVD</a></li>
                    <li><a href="#Radio">Radio</a></li>
                    <li><a href="#Secret Device">Nothing</a></li>
                </ul>
            </li>
    	</ul>
</div>
<div>
<form method="post" action="Blink">
	<input class="bg-green bg-hover-lime fg-white" type="submit" value="LET THERE BE LIGHT" style="font-size:40px; height:200px; width:600px;">
</form>
</div>
</body>
</html>