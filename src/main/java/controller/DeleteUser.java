package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UtilisateurDao;



@WebServlet("/user/delete")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null && id.matches("[0-9]+"))
		{
			UtilisateurDao.supprimer(Integer.parseInt(id));
		}

		response.sendRedirect(request.getContextPath()+"/user/list");
	}

}
