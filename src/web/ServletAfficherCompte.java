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
import metier.Compte;
import metier.CompteModel;

/**
 * Servlet implementation class ServletAfficherClient
 */
@WebServlet("/ServletAfficherCompte")
public class ServletAfficherCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatalogueImpl metier ;
	public void init() throws ServletException
    {
 	   metier=new CatalogueImpl();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAfficherCompte() {
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
		
		
		CompteModel model= new CompteModel() ;
		request.setAttribute("model", model);
		String action=request.getParameter("action1");
		if(action!=null){
			
			
			if (action.equals("supprimer"))
			{
			 
				String em=request.getParameter("em");
				int d= Integer.parseInt(em);
				metier.deleteCompte(d);
			model.setComptes(metier.listComptes());
			}
			
		else if(action.equals("chercher"))
			{        
				model.setMotCle(request.getParameter("motCle"))	;
				String ch=model.getMotCle() ;
				if(ch!="")
				{
				int d= Integer.parseInt(ch);
				System.out.println(d);
				List<Compte> comptes=metier.getComptes(d);
				model.setComptes(comptes);
				}
				else
				{ List<Compte> comptes=metier.listComptes();
				model.setComptes(comptes);
				}
				
				}
			}
			
		
	
		request.getRequestDispatcher("client.jsp").forward(request, response);
		
	}

}
