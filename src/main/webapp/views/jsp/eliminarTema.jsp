<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Tema</title>
</head>
<body>
<h2>Eliminar Tema</h2>
<c:set var="bean" scope="request" value="${eliminarTemaBean}" />
<form method="post" action="eliminarTema">
	Selecciona el tema a elminiar:</br>
	<select name="select" id="select" >
		<c:forEach var="tema" items="${bean.temas}">
			<option value="${tema.id}">${tema.name}</option>
		</c:forEach>
	</select>
	<input type="submit" value="Eliminar"/>		
</form>
<br/>
<br/>
<br/>
<a href="/JEE_ECP/jsp/home">Volver a Home</a>
</body>
</html>