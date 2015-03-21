<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Tema</title>
</head>
<body>
<h1>Nuevo Tema:</h1>
<form action="addTema" method="post">
	Nombre: <input name="nombre" type="text"/><br/><br/>
	Pregunta: <input name="pregunta" type="text"/><br/><br/>
	<input type="submit" value="Añadir Tema"/>	
</form>
<br/>
<br/>
<br/>
<a href="index.html">Volver a Página Principal</a>
</body>
</html>