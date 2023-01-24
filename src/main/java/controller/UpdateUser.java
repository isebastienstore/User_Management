package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UserDao;
import dao.UtilisateurDao;
import forms.AddUserForm;



@WebServlet("/user/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_MODIFIER_UTILISATEUR = "/WEB-INF/updateUser.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");
		System.out.println(id);

		if (id != null && id.matches("[0-9]+"))
		{
			Utilisateur utilisateur = UtilisateurDao.get(Integer.parseInt(id));
			

			if (utilisateur != null)
			{
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher(VUE_MODIFIER_UTILISATEUR).forward(request, response);
				return;
			}
		}

		response.sendRedirect(request.getContextPath()+"/user/list");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		AddUserForm form = new AddUserForm(request);
		
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (id != null && id.matches("[0-9]+"))
		{
			Utilisateur utilisateur = new Utilisateur(Integer.parseInt(id), nom, prenom, login, password);
			if(form.modifier()) {
				response.sendRedirect(request.getContextPath()+"/user/list");
			}
			else {
				request.setAttribute("utilisateur", form.getUtilisateur()); 
				request.setAttribute("status", form.isStatus());
				request.setAttribute("statusMessage", form.getStatusMessage());
				request.setAttribute("errors", form.getErrors());
				this.getServletContext().getRequestDispatcher(VUE_MODIFIER_UTILISATEUR).forward(request, response);
			}
		}
	}
}