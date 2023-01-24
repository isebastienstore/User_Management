<%@page import="beans.Utilisateur"%> 
<%@include file="header.jsp" %>
<body>
<%@include file="menu.jsp" %>
	<div id="corps">
		<h1 id="titre-principal">Mettre à jour un utilisateur</h1>
		<div class="${status ? 'success' : 'error' }">
			${statusMessage }
		</div>
		<form method="post">
			<div class="formItem">
				<label>Nom</label>
				<input type="text" name="nom" value="${utilisateur.nom }"><br>
				<span class="error">${errors.nom}</span>
			</div>
			<div class="formItem">
				<label>Prénom</label>
				<input type="text" name="prenom" value="${utilisateur.prenom}"><br>
				<span class="error">${errors.prenom}</span>
			</div>
			<div class="formItem">
				<label>Login</label>
				<input type="text" name="login" value="${utilisateur.login}"><br>
				<span class="error">${errors.login}</span>
			</div>
			<div class="formItem">
				<label>Password</label>
				<input type="password" name="password"><br>
				<span class="error">${errors.password}</span>
			</div>
			<div class="formItem">
				<label>Password (confirmation)</label>
				<input type="password" name="passwordBis"><br>
				<span class="error">${errors.passwordBis}</span>
			</div>
			<div class="formItem">
				<label></label>
				<input type="submit" value="Modifier">
			</div>
		</form>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>