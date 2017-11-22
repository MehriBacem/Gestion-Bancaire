package metier;

import java.io.Serializable;

public class User  implements Serializable{

	
	
	private  String login ;
	private String motDePasse ;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String login, String motDePasse) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
}
