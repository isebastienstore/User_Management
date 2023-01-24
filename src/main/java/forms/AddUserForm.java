package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UserDao;
import dao.UtilisateurDao;

public class AddUserForm {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez remplir ce champs !";
	private static final String WRONG_PASSWORD_ERROR_MESSAGE_STRING = "Les deux mots de passe ne sont pas conformes";
	
	private HttpServletRequest request;
	private Map<String, String> errors;
	private boolean status;
	private String statusMessage;
	private Utilisateur utilisateur;
	
	
	public AddUserForm(HttpServletRequest request) {
		this.status = false;
		this.request = request;
		this.errors = new HashMap<>(); 
	}
	
	public boolean ajouter() {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login =  getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);
		
		this.utilisateur = new Utilisateur(nom, prenom, login, password);
		
		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
		validerPassword();
		
		statusMessage = "Echec de l'ajout !";
		
		if (errors.isEmpty()){
			status = UtilisateurDao.ajouter(utilisateur);
			if(status) {
				statusMessage = "Utilisateur ajouté avec succès !";
			}
			
		}
				
		return status;		
	}
	
	public boolean modifier() {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login =  getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);
		
		this.utilisateur = new Utilisateur(nom, prenom, login, password);
		
		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
		validerPassword();
		
		statusMessage = "Echec de la modification !";
		
		if (errors.isEmpty()){
			status = UtilisateurDao.modifier(utilisateur);
			if(status) {
				statusMessage = "Utilisateur modifié avec succès !";
			}
			
		}
				
		return status;		
	}
	

	private String getParameter(String parametre) {
		String valeur = this.request.getParameter(parametre);
		return (valeur == null || valeur.trim().isEmpty() ? null : valeur.trim());
	}
	
	private void validerChamps(String... parametres) {
		for(String parametre : parametres) {
			if (this.getParameter(parametre) ==null) {
				errors.put(parametre, EMPTY_FIELD_ERROR_MESSAGE);
			}
		}
	}
	
	private void validerPassword() {
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);
		
		if (password != null && !password.equals(passwordBis)) {
			errors.put(CHAMP_PASSWORD, WRONG_PASSWORD_ERROR_MESSAGE_STRING);
			errors.put(CHAMP_PASSWORD_BIS, WRONG_PASSWORD_ERROR_MESSAGE_STRING);
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
		
	}

	/*
	 * public HttpServletRequest getRequest() { return request; }
	 * 
	 * public void setRequest(HttpServletRequest request) { this.request = request;
	 * }
	 */
	/*
	 * MD5 est une fonction e hashage. recuper les mdp stockés dans une database et hashés avec MD5
	 * on peut utiliser en sql: select md5('passer') mettra 'passer' dans la fonction de hashage avant de la renvoyer
	 */
	
}

