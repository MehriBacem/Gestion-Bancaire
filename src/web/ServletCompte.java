package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueImpl;
import metier.Client;
import metier.ClientModel;
import metier.Compte;

/**
 * Servlet implementation class ServletCompte
 */
@WebServlet("/ServletCompte")
public class ServletCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatalogueImpl metier ;
	private String action1="";
	public void init() throws ServletException
    {
 	   metier=new CatalogueImpl();
    }
    public ServletCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		
	{	
		ClientModel model= new ClientModel() ;
		request.setAttribute("model", model);
		action1 = request.getParameter("action1");
		Compte cpt= new Compte();
		Client cl= new Client();
		if(action1!=null)
		{ if(action1.equals("ajouter"))
			{   String solde=request.getParameter("solde");
			
				Double d=Double.parseDouble(solde);
				String email=request.getParameter("em");
				cpt.setSolde(d);
				cl=metier.getClient(email);
				cpt.setC(cl);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
				Date date = new Date();
				
				cpt.setDateCreation(dateFormat.format(date));
				
				
				metier.addCompte(cpt, request, cl.getId());	
				model.setClients(metier.listClients());
				 request.setAttribute("msg", "Felicitation le compte a été crée avec Succes "); 
				
			}
			
			
	 else   if( action1.equals("chercher"))
			{
				model.setMotCle(request.getParameter("motCle"))	;
				List<Client> clients=metier.listClientsParNom(model.getMotCle());
				model.setClients(clients);
				String solde=request.getParameter("solde");
				if(solde!="")
				{	Double d=Double.parseDouble(solde);
				request.setAttribute("solde", d);}
			}
	
	 
	
		request.getRequestDispatcher("AncienClient.jsp").forward(request, response);
		
}
	}
}
