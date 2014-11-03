<% /* if (request.getSession().getAttribute("sessionId") == null) {
	response.sendRedirect(response.encodeURL("./Login"));
	}*/ %>
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
<div class="container">
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
                </ul>
            </li>
            <li><a href="./Logout">Logout</a>
    	</ul>
    </nav>	
</nav>

<!-- Body -->
<div class="grid" style="margin-left:2%;margin-top:5%">

	<div class="grid">
	    
		<form method="post" action="getDevice">
			<div class="row" >
				<div class="span5">
					<input name="button" class="bg-lightBlue bg-hover-darkBlue fg-white" type="submit" value="List all devices			" style="font-size:150%; height:45px; width:78%;">
				</div>	
			</div>
			<div class="row">	
				<div class="span5">
				<div class="accordion with-marker span4 place-left" data-role="accordion" data-closeany="false">
                
					<div class="accordion-frame" style="font-size:150%;">
    					<a class="heading bg-lightBlue fg-white collapsed" href="#">Remove a device</a>
       	 				<div class="content" style="display: none;">
        					<p>Fill in the ID of the device <br>that should be removed.<p>
        					<p><input name="remDev" type="text" data-state="info"></p>
        					<p><input name="button" class="bg-lightBlue bg-hover-darkBlue fg-white" type="submit" value="Remove" style="font-size:100%; height:50px; width:63%;"></p>
        				</div>
					</div>
				</div></div>
			</div>
			<div class="row">	
				<div class="accordion with-marker span4 place-left" data-role="accordion" data-closeany="false">
                
					<div class="accordion-frame" style="font-size:150%;">
    					<a class="heading bg-lightBlue fg-white collapsed" href="#">Add a device</a>
       	 				<div class="content" style="display: none;">
       	 					<p>Fill in the name of the device <br>that should be added.<p>
        					<p><input name="addDev" type="text" data-state="info"></p>
        					<p><input name="button" class="bg-lightBlue bg-hover-darkBlue fg-white" type="submit" value="Add" style="font-size:100%; height:50px; width:63%;"></p>
        				</div>
					</div>
				</div></div>		
		</form>
	</div>
</div>
</div>
</body>
</html>
