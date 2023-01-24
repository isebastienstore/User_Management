<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	   <!--       <c:if test="${ !empty nom }"><p><c:out value="Bonjour, vous vous appelez ${ nom }" /></p></c:if> -->
        
        <form method="get" action="login">
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
            
            <input type="submit" />
        </form>
        
</body>
</html>