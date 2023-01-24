package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UserDao;
import forms.AddUserForm;


@WebServlet("/user/add")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/addUser.jsp";
       

    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddUserForm form = new AddUserForm(request);
		
		if (form.ajouter()) {
			response.sendRedirect(request.getContextPath()+"/user/list");
		}
		else {
			request.setAttribute("utilisateur", form.getUtilisateur()); 
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("errors", form.getErrors());
			this.getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
		}
	}

}
