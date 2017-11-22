package metier;

import java.io.Serializable;

public class Operation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int id_operation ;
	private  String type ;
	private double  montant ;
	private String dateOperation ;
	private String dateValeur ;
	private Compte c ;
	private double solde ;
	public int getId_operation() {
		return id_operation;
	}
	public void setId_operation(int id_operation) {
		this.id_operation = id_operation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Operation(String type, double montant, Compte c) {
		super();
		this.type = type;
		this.montant = montant;
		this.c = c;
	}
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}
	public String getDateValeur() {
		return dateValeur;
	}
	public void setDateValeur(String dateValeur) {
		this.dateValeur = dateValeur;
	}
	public Compte getC() {
		return c;
	}
	public void setC(Compte c) {
		this.c = c;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	

}
