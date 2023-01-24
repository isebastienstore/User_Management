package beans;

public class Utilisateur {
	private static final long serialVersionUID = 1L;
    private int 	lastId;   
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
    public Utilisateur(String nomString) {
		super();
		this.nom = nomString;
	}

	public Utilisateur(String nomString, String prenomString) {
		super();
		this.nom = nomString;
		this.prenom = prenomString;
	}
	

	public Utilisateur(int lastId, String nomString, String prenomString, String loginString, String passwordString) {
		super();
		this.lastId = lastId;
		this.nom = nomString;
		this.prenom = prenomString;
		this.login = loginString;
		this.password = passwordString;
	}

	public Utilisateur(String nomString, String prenomString, String loginString, String passwordString) {
		this(0, nomString, prenomString, loginString, passwordString);
	}

	public Utilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nomString) {
		this.nom = nomString;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenomString) {
		this.prenom = prenomString;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String loginString) {
		this.login = loginString;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwordString) {
		this.password = passwordString;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", login=" + login +", password=" + password +"]";
	}
	
}
