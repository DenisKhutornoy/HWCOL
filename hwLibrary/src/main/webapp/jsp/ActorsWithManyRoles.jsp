<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library</title>
</head>

<body>
    <c:import url="/jspf/header.jspf"></c:import>
	<form action="ActorsWithManyRoles" method="post">
<input type="submit"/>
	</form>
	<c:forEach items="${actors}" var="item" >
	   ${item} <br/>
	</c:forEach>
</body>
</html>