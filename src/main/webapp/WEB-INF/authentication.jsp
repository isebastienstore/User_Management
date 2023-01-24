<%@page import="beans.Utilisateur, java.util.ArrayList"%>
<%@include file="header.jsp" %>
<body>
<%@include file="menu.jsp" %>
	<div id="corps">
		<h1 id="titre-principal">AUTHENTIFICATION D'UN UTILISATEUR</h1>
		<form method="post">
			<div class="formItem">
				<label>Login</label>
				<input type="text" name="login" value="${utilisateur.login }"><br>
			</div>
			<div class="formItem">
				<label>Password</label>
				<input type="password" name="password" value=""><br>
				<span>${errors}</span>
			</div>
			<div class="formItem">
				<label></label>
				<input type="submit" value="Connexion">
			</div>
		</form>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>