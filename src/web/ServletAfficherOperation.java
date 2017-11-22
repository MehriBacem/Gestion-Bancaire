package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueImpl;
import metier.Client;
import metier.Compte;
import metier.CompteModel;
import metier.Operation;
import metier.OperationModel;

/**
 * Servlet implementation class ServletAfficherOperation
 */
@WebServlet("/ServletAfficherOperation")
public class ServletAfficherOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatalogueImpl metier ;
	public void init() throws ServletException
    {
 	   metier=new CatalogueImpl();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAfficherOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperationModel model= new OperationModel() ;
		request.setAttribute("model", model);
		String action=request.getParameter("action1");
		if(action!=null){
			
			
		
			
	 if(action.equals("Afficher"))
			{        
				model.setMotCle(request.getParameter("motCle"))	;
				String ch=model.getMotCle() ;
				if(ch!="")
				{
				int d= Integer.parseInt(ch);
				Compte cpt=metier.consulterCompte(d);
				request.setAttribute("cpt", cpt);
				List<Operation> operations=metier.listOperations(d);
				model.setOperations(operations);
				}
			}
	
		
		request.getRequestDispatcher("listeOperation.jsp").forward(request, response);}

}}
