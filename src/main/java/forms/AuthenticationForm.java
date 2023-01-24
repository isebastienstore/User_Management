package forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UserDao;
import dao.UtilisateurDao;

public class AuthenticationForm {
	
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	
	
	private HttpServletRequest request;
	private Utilisateur utilisateur;
	private String login;
	private boolean status;

	
	
	public AuthenticationForm(HttpServletRequest request) {
		super();
		this.request = request;
	}



	public boolean authentifier() {
		String login =  getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD); 
	/*	if("admin".equals(login) && "passer".equals(password)) {
			utilisateur = new Utilisateur("ADMIN", "ADMIN", "admin", "ADMIN");
		}*/
		if(login != null)
		{
			status = UtilisateurDao.login(login, password);
			return status;
		}
		return false;
	}
	
	private String getParameter(String parametre) {
		String valeur = this.request.getParameter(parametre);
		return (valeur == null || valeur.trim().isEmpty() ? null : valeur.trim());
	}



	public String getLogin() {
		// TODO Auto-generated method stub
		return login;
	}
	

}
