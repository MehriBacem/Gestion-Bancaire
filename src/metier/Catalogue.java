package metier;

import java.util.List ;

import javax.servlet.http.HttpServletRequest;
public interface Catalogue {
	
	public void addClient(Client c,HttpServletRequest request);
	public List<Client> listClients() ;
	public void updateClient (Client c) ;
	public void deleteClient(String email);
	public List<Client> listClientsParNom(String ch);
	public Client getClient(String email);
	public Client getClientParId(int id);
	public void addCompte(Compte c,HttpServletRequest request,int codeCli) ;
	public List<Compte> getComptes(int codCli);
	public Compte consulterCompte(int codeCompte);
	public void deleteCompte(int id_compte);
	public void updateCompte (double solde,int codeCompte) ;
	public List<Compte> listComptes() ;
	public void addOperation(Operation o,HttpServletRequest request,int codeCompte) ;
	public Compte getCompteById(int id_compte) ;
	public List<Operation> listOperations(int codeCompte) ;
	
	public Operation TrouverOperation(String date, int id);
	public void deleteOperation(int id) ;
	public void deleteOperation1(int id1) ;
	public void versement_retrait (Operation o) ;
	
	

}
