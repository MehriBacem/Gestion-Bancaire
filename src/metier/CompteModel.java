package metier;

import java.util.ArrayList;
import java.util.List;

public class CompteModel {
	
	
	private	String motCle ;
	private List<Compte> comptes=new ArrayList<Compte>();
	public CompteModel(String motCle, List<Compte> comptes) {
		super();
		this.motCle = motCle;
		this.comptes = comptes;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public CompteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
