<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votar</title>
</head>
<script type="text/javascript">
	function mostrarValor(valor){
		document.getElementById("valor").innerHTML = valor;
	}
</script>
<body>
<h2>Votar</h2>
<c:set var="bean" scope="request" value="${votarBean}" />
${bean.mensaje}<br/><br/><br/>
<form method="post" action="votar">
	Selecciona un tema </br>
	<select name="temaSeleccionado" id="select" >
		<c:forEach var="tema" items="${bean.temas}">
			<option id="id" value="${tema.id}">${tema.nombre}</option>
		</c:forEach>
	</select>
	<input type="submit" value="Elegir"/>		
</form>
<c:if test="${bean.tema != null}">
	<form method="post" action="votar">
		<br/><br/>
		<h3>Pregunta:<br/></h3>
		${bean.tema.pregunta}<br/><br/>
		Valoracion (0 a 5):  
		<input type="range" name="valoracion" value="0" min="0" max="5" step="1" onchange="mostrarValor(this.value)"/>
		<span id="valor">0</span>
		<br/><br/>
		Selecciona tu nivel de estudios</br>
		<select name="nivelEstudios" id="select" >
			<c:forEach var="nivel" items="${bean.nivelesEstudio}">
				<option id="id" value="${nivel}">${nivel}</option>
			</c:forEach>
		</select>
		<br/><br/>
		<input type="hidden" name="tema" value="${bean.tema.id}" />
		<input type="submit" value="Votar"/>
	</form>
</c:if>
<br/>
<br/>
<br/>
<a href="/JEE_ECP/jsp/home">Volver a Home</a>
</body>
</html>