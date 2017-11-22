package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueImpl;
import metier.Client;

/**
 * Servlet implementation class ServletModifierClient
 */
@WebServlet("/ServletModifierClient")
public class ServletModifierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CatalogueImpl metier ;
    RequestDispatcher dispatcher = null ;
    public void init() throws ServletException
    {
 	   metier=new CatalogueImpl();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int a=0 ;
Client cl =new Client() ;
String ch= (String) request.getSession().getAttribute("msg");


if(ch!=null){
  a = Integer.parseInt(ch) ;}
   
		String action=request.getParameter("action1") ;
		RequestDispatcher dispatcher = null ;
		if(action!=null)

			{  if(action.equalsIgnoreCase("ModifierClient"))
			{
			cl.setNom(request.getParameter("nom"));
			
		cl.setPrenom(request.getParameter("prenom"));
		cl.setAdresse(request.getParameter("adress"));
		cl.setTelephone(request.getParameter("telephone"));
		cl.setEmail(request.getParameter("adresse"));
		cl.setPassword(request.getParameter("motDePasse1"));
		cl.setId(a);
	
		metier.updateClient(cl);
	
		request.setAttribute("cl",cl) ;

	}}
		request.getRequestDispatcher("modifierClient.jsp").forward(request, response);	}
	
}


