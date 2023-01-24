package dao;


import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import beans.Utilisateur;

public class UserDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int lastId = 0;
	private static final ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
	
	public static boolean ajouter(Utilisateur utilisateur) {
		utilisateur.setLastId(++lastId);
		utilisateurs.add(utilisateur);
		return true;
	}
	
	public static ArrayList<Utilisateur> lister(){
		return utilisateurs;
	}
	
	public static boolean modifier(Utilisateur utilisateur)
	{
		for (Utilisateur user : utilisateurs)
		{
			if (utilisateur.getLastId() == user.getLastId())
			{
				user.setNom(utilisateur.getNom());
				user.setPrenom(utilisateur.getPrenom());
				user.setLogin(utilisateur.getLogin());
				user.setPassword(utilisateur.getPassword());

				return true;
			}
		}

		return false;
	}

	public static boolean supprimer(int id)
	{
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getLastId() == id)
			{
				utilisateurs.remove(utilisateur);
				return true;
			}
		}

		return false;
	}

	public static Utilisateur get(int id)
	{
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getLastId() == id)
			{
				return utilisateur;
			}
		}

		return null;
	}

	public static Utilisateur get(String login) {
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getLogin().equals(login))
			{
				return utilisateur;
			}
		}
		return null;
	}


}
