<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>s
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Courses available</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet"> 
        <link href="css/lightbox.css" rel="stylesheet"> 
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
</head>
<body>

    <div class="container-fluid">
    <nav class="navbar navbar-inverse navbar-fixed-top">
      
            <div>
                    <jsp:include page="/Nav.jsp"/>
            </div>
             
    </nav>
    </div>
    
    <br>
    <br>

    <div class="container-fluid ">
      <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header text-center">List Of Course Session</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Session Id</th>
                  <th>Start Date</th>
                  <th>End Date</th>
                  <th>Course Name</th>
                  <th>Location</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${CourseSession}" var="CourseSessionMap">
               <tr>
                 <td><c:out value="${CourseSessionMap.sessionId }"></c:out></td>
                 <td><c:out value="${CourseSessionMap.startdate }"></c:out></td>
                 <td><c:out value="${CourseSessionMap.enddate }"></c:out></td>
                 <td><c:out value="${CourseSessionMap.course.CODE }"></c:out></td>
                 <td><c:out value="${CourseSessionMap.location.city }"></c:out></td>
                 <td>
                    <form action="InscriptionClients" method="POST">
                        <button type="submit" style="background-color: Transparent;border: none;cursor:pointer;  overflow: hidden;">
                            <img src="https://community.upwork.com/html/assets/Register_40.png"
                                                       alt="SomeAlternateText"/>
                        </button>
                        <input type="hidden" name="course_no" value="${CourseSessionMap.sessionId}" />
                    </form>
                 </td>
                 </tr>
               </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/lightbox.min.js"></script>
    <script type="text/javascript" src="js/wow.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
