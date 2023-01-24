<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Données envoyées</title>
</head>
<body>
	<h1>Identification d'un utilisateur</h1>
	<jsp:useBean id="utilisateur" scope="request" class="beans.Utilisateur"></jsp:useBean>
	<jsp:setProperty property="*" name="utilisateur"/>
	
	<p>
		<jsp:getProperty property="nom" name="utilisateur"/>
	</p>
</body>
</html>