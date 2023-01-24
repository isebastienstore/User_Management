<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date du jour</title>
</head>
<body>
<h1>Date du jour</h1>

<% Date date = new Date(System.currentTimeMillis());%>
<p>Nous somme le <% out.println(date.toLocaleString());%></p>
</body>
</html>