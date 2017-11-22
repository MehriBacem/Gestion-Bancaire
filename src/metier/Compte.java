package metier;

import java.io.Serializable;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
public class Compte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id ;
	private Client c ;
	private String dateCreation ;
	private double solde ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getC() {
		return c;
	}
	public void setC(Client c) {
		this.c = c;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte( Client c, double solde, double taux) {
		super();
		
		this.c = c;
		this.solde = solde;
		
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String string) {
		this.dateCreation = string;
	}
	
	
	

}
