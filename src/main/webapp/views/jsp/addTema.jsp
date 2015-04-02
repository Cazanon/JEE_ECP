<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Tema</title>
</head>
<body>
<h2>Nuevo Tema</h2>
<c:set var="bean" scope="request" value="${addTemaBean}" />
<form method="post" action="addTema">
	Nombre: <input name="nombre" type="text"/><br/><br/>
	Pregunta: <input name="pregunta" type="text"/><br/><br/>
	<input type="submit" value="Añadir Tema"/>	
</form>
<br/>
<br/>
<br/>
<a href="/JEE_ECP/jsp/home">Volver a Home</a>
</body>
</html>