package metier ;

import java.io.Serializable;
import java.util.Collection;

public class Client implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Telephone;
	private String  Email;
  private String Password ;
  private Collection<Compte> comptes ;
  
  public Client( String nom, String prenom, String adresse, String telephone, String email, String password) {
	super();
	
	Nom = nom;
	Prenom = prenom;
	Adresse = adresse;
	Telephone = telephone;
	Email = email;
	Password = password;
}
public Client() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int numcli) {
		id=numcli;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	

}
