package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Catalogue;
import metier.CatalogueImpl;
import metier.Client;
import metier.ClientModel;

/**
 * Servlet implementation class ServletAfficherClient
 */
@WebServlet("/ServletAfficherClient")
public class ServletAfficherClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatalogueImpl metier ;
	public void init() throws ServletException
    {
 	   metier=new CatalogueImpl();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAfficherClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ClientModel model= new ClientModel() ;
		request.setAttribute("model", model);
		String action=request.getParameter("action1");
		if(action!=null){
			
			
			if (action.equals("supprimer"))
			{
			 
				String email=request.getParameter("em");
				metier.deleteClient(email);
			model.setClients(metier.listClients());
			}
			
		else if(action.equals("chercher"))
			{
				model.setMotCle(request.getParameter("motCle"))	;
				List<Client> clients=metier.listClientsParNom(model.getMotCle());
				model.setClients(clients);
				
			}
		
			
		}
	
		request.getRequestDispatcher("AfficherClient.jsp").forward(request, response);
		
	}

}
