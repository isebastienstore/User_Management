package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UserDao;
import dao.UtilisateurDao;


@WebServlet("/user/list")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE_UTILISATEURS = "/WEB-INF/listUser.jsp"; 
 
    public ListUser() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Utilisateur> utilisateurs = UtilisateurDao.lister();
		request.setAttribute("utilisateurs", utilisateurs);
		this.getServletContext().getRequestDispatcher(VUE_UTILISATEURS).forward(request, response);
	}

}
