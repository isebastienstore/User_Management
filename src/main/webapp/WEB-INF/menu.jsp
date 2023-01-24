
	<div id="entete">GESTION DES UTILISATEURS</div>
	<div id="menu">
		<ul>
			<li><a href="<%= request.getContextPath() %>">Accueil</a></li>
			<% if(session.getAttribute("isConnected")==null){%>
				<li><a href="<%= request.getContextPath() %>/login">Connexion</a></li>
			<% }
			else{%>	
				<li><a href="<%= request.getContextPath() %>/user/list">Lister</a></li>
				<li><a href="<%=request.getContextPath() %>/user/add">Ajouter</a></li>
				<li><a href="<%=request.getContextPath() %>/logout">Déconnexion</a></li>
		<%	}%>
		</ul>
	</div>