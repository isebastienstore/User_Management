package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import forms.AuthenticationForm;

/**
 * Servlet implementation class Authentication
 */
@WebServlet({"/login", "/logout"})
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final String VUE_CONNEXION = "/WEB-INF/authentication.jsp";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/login": {
			this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
			break;
		}
		default:
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+ "/login");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthenticationForm form = new AuthenticationForm(request);
		HttpSession session = request.getSession();
		
		if (form.authentifier()) {
			session.setAttribute("isConnected", true);
			
			response.sendRedirect(request.getContextPath()+"/user/list");
		} 
		else {
			response.sendRedirect( request.getContextPath()+ "/login?user=" + form.getLogin());
		}
	}

}
