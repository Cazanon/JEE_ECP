<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temas</title>
</head>
<body>
Temas:
<c:set var="listaTemas" scope="request" value="${temas}"/>
<c:forEach var="tema" items="${listaTemas}">
	<li>${tema.nombre},${tema.pregunta}</li>
</c:forEach>
<br/>
<br/>
<br/>
<a href="index.html">Volver a Página Principal</a>
</body>
</html>