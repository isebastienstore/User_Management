<%@page import="beans.Utilisateur, java.util.ArrayList"%>
<%
	ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs"); 
%>
<%@include file="header.jsp" %>
<body>
<%@include file="menu.jsp" %>
	<div id="corps">
		<h1 id="titre-principal">LISTE DES UTILISATEURS</h1>
		<%
			if(utilisateurs.isEmpty())
			{%>
				<p>Liste des utilisateurs vide !</p><%
			} 
			else
			{%>
				<table>
					<tr>
						<th>ID</th>
						<th>Prénom</th>
						<th>Nom</th>
						<th>Login</th>
						<th>Password</th>
						<th colspan="2">Actions</th>
					</tr><%
					for (Utilisateur user : utilisateurs)
					{
						request.setAttribute("utilisateur", user);%>
						<tr>
							<td>${utilisateur.lastId }</td>
							<td>${utilisateur.nom }</td>
							<td>${utilisateur.prenom }</td>
							<td>${utilisateur.login }</td>
							<td>${utilisateur.password }</td>
							<td><a href="<%= APP_ROOT %>/user/update?id=${utilisateur.lastId }">Modifier</a></td>
							<td><a href="<%= APP_ROOT %>/user/delete?id=${utilisateur.lastId }" onclick="return confirmSuppression()">Supprimer</a></td>
						</tr><%
					}%>
				</table><%
			}
		%>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>