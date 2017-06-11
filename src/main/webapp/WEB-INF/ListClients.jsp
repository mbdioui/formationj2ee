<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log4j</title>

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
    
    <br>
    <br>
    <br>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">List Of Clients</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID Client</th>
                  <th>Nom CLiente</th>
                  <th>Prenom Client</th>
                  <th>Address</th>
                  <th>Téléphone</th>
                  <th>Email</th>
                  <th>CourseSession ID</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${client}" var="clientMap">
               <tr>
                 <td><c:out value="${clientMap.ID_Client }"></c:out></td>
                 <td><c:out value="${clientMap.LASTNAME }"></c:out></td>
                 <td><c:out value="${clientMap.FIRSTNAME }"></c:out></td>
                 <td><c:out value="${clientMap.ADDRESS }"></c:out></td>
                 <td><c:out value="${clientMap.PHONE }"></c:out></td>
                 <td><c:out value="${clientMap.EMAIL }"></c:out></td>
                 <td><c:out value="${clientMap.coursession.sessionId }"></c:out></td>
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