<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h1>Calculator</h1>	
	<spring:url value="/calculator/" var="adminUrl" />
	<a href="${adminUrl}" title="Admin">Login</a>
</body>
</html>
