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
<c:if test="${bean.existe}">
	Tema no insertado, ya existe un tema con ese nombre.
	<br/><br/><br/>
</c:if>
<form method="post" action="addTema">
	<c:if test="${bean.added}">
		Nombre: <input name="nombre" type="text"/><br/><br/>
		Pregunta: <input name="pregunta" type="text"/><br/><br/>
	</c:if>
	<c:if test="${!bean.added}">
		Nombre: <input name="nombre" type="text" value="${bean.tema.nombre}"/><br/><br/>
		Pregunta: <input name="pregunta" type="text" value="${bean.tema.pregunta}"/><br/><br/>
	</c:if>	
	<input type="submit" value="Add Tema"/>	
</form>
<br/>
<br/>
<br/>
<a href="/JEE_ECP/jsp/home">Volver a Home</a>
</body>
</html>