<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Inscription</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet"> 
    <link href="css/lightbox.css" rel="stylesheet"> 
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
	
</head>
<body>

    <div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top">   
            <div>
                    <jsp:include page="/Nav.jsp"/>
            </div>
    </nav>
    </div>
            <br><br>
	
	<section id="projects" class="padding-top">
        <div class="container">
         <div><center><h1>INSCRIPTION</h1></center></div><BR>

                            <center><form action="Subscription" method="POST">
                            
                            <div class="form-group">
                                <input type="text" name="FirstName" class="form-control" required="required" placeholder="First Name">
                            </div>
							
                            <div class="form-group">
                                <input type="text" name="LastName" class="form-control" required="required" placeholder="Last Name">
                            </div>
                            
                            <div class="form-group">
                                <input type="text" name="address" class="form-control" required="required" placeholder="Address">
                            </div>
                            
                            <div class="form-group">
                                <input type="text" name="email" class="form-control" required="required" placeholder="Email">
                            </div>
							
                            <div class="form-group">
                                <input type="number" name="phone" class="form-control" required="required" placeholder="Phone">
                            </div>
                            
                            <div>
                                <input type="submit"  class="btn btn-primary btn-lg" value="Confirmer">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset"  class="btn btn-primary btn-lg " value="Annuler"><br><br>
                            </div>
                                    <input type="hidden" value="${course_no}" name="course_no" />
                            </form></center>						
        </div>
    </section>

<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/lightbox.min.js"></script>
    <script type="text/javascript" src="js/wow.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>

</body>
</html>