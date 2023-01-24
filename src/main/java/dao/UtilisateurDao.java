package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao {
	
	// Pour la base de données
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String username = "root";
	private static String password = "";
	
	private static int lastId = 0;
	private static final ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	private static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
		}
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}
	
	public static boolean ajouter(Utilisateur utilisateur) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// using the database
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO utilisateur(nom, prenom, login, pwd) VALUES (?,?,?,?);");
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			
			preparedStatement.executeUpdate();
			
//			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static ArrayList<Utilisateur> lister(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
		
		// using the database
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT lastId, nom, prenom, login, pwd FROM utilisateur;");
			
			while (resultat.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setLastId(resultat.getInt("lastId"));
				utilisateur.setNom(resultat.getString("nom"));
				utilisateur.setPrenom(resultat.getString("prenom"));
				utilisateur.setLogin(resultat.getString("login"));
				utilisateur.setPassword(resultat.getString("pwd"));
				users.add(utilisateur);
			}
			
//			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}
	
	public static boolean supprimer(int id)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// using the database
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM utilisateur WHERE lastId = ?;");
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	} 
	
	public static boolean modifier(Utilisateur utilisateur)
	{
		
		// pour la base de données
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// using the database
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement("UPDATE utilisateur set nom = ?, prenom = ?, login = ?, pwd = ? WHERE lastId = ?;");
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			preparedStatement.setInt(5, utilisateur.getLastId());
			
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Utilisateur get(int id) {
		
		// pour la base de données
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		Utilisateur utilisateur = new Utilisateur();
		// using the database
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT lastId, nom, prenom, login, pwd FROM utilisateur WHERE lastId = " + id + ";");
			
			while (resultat.next()) {
				utilisateur.setLastId(resultat.getInt("lastId"));
				utilisateur.setNom(resultat.getString("nom"));
				utilisateur.setPrenom(resultat.getString("prenom"));
				utilisateur.setLogin(resultat.getString("login"));
				utilisateur.setPassword(resultat.getString("pwd"));
				return utilisateur;
			}
			
//			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public static Utilisateur get(String login) {
		
		// pour la base de données
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		Utilisateur utilisateur = new Utilisateur();
		// using the database
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT lastId, nom, prenom, login, pwd FROM utilisateur WHERE login = '" + login + "';");
			
			while (resultat.next()) {
				utilisateur.setLastId(resultat.getInt("lastId"));
				utilisateur.setNom(resultat.getString("nom"));
				utilisateur.setPrenom(resultat.getString("prenom"));
				utilisateur.setLogin(resultat.getString("login"));
				utilisateur.setPassword(resultat.getString("pwd"));
				return utilisateur;
			}
			
//			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
//		for (Utilisateur utilisateur: utilisateurs) {
//			if (utilisateur.getLogin() == id) {
//				return utilisateur;
//			}
//		}
//		
//		return null;
	}
	
	public static boolean login(String login, String password) {
		
		// base de données 
		
		
		Utilisateur user = get(login);
		
		if (user == null) {
			return false;
		}
		
		String dbLogin = user.getLogin();
		String dbPassword = user.getPassword();
		
		if (login.equals(dbLogin) && dbPassword.equals(password))
		{
			return true;
		}
		else {
			return false;
		}	
	}
}
