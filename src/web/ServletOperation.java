package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueImpl;
import metier.Compte;
import metier.Operation;

/**
 * Servlet implementation class ServletOperation
 */
@WebServlet("/ServletOperation")
public class ServletOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatalogueImpl metier ;
	public void init() throws ServletException
    {
 	   metier=new CatalogueImpl();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 String ch =request.getParameter("numcp") ;
		 if(ch!=null){
		int  a = (int)Integer.parseInt(ch) ;
		
		  Compte c =metier.consulterCompte(a);
		   Operation o = new Operation() ;
		
		  o.setC(c);
		  String ch1=request.getParameter("type") ;
		  o.setType(ch1);
			  String ch2=request.getParameter("MontantOp");
			  if(ch2!=null){
			  Double d = (double)Double.parseDouble(ch2);
			  o.setMontant(d);metier.versement_retrait(o);}
			  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				
				Date date1=null ;
				o.setDateOperation(dateFormat.format(date));
				Operation o1=metier.TrouverOperation(dateFormat.format(date),a);
				if(o1.getId_operation()==0)
				{
				if(ch1!=null){
				if(ch1.equals("Versement"))
				{
				 date1=new Date(date.getTime()+(1000*60*60*24)) ;}
				else {
					
			 date1=new Date(date.getTime()-(1000*60*60*24)) ;
				}
				o.setDateValeur(dateFormat.format(date1));
				Compte cpt=metier.consulterCompte(o.getC().getId()) ;
				o.setSolde(cpt.getSolde());	
				metier.addOperation(o, request, a);}}
				else { 
				String ch4=o1.getType() ;
				if(ch4.equals("Versement")){if(ch1.equals("Versement")){o.setMontant(o.getMontant()+o1.getMontant());o.setDateValeur(dateFormat.format(new Date(date.getTime()+(1000*60*60*24))));Compte cpt=metier.consulterCompte(o.getC().getId()) ;
				o.setSolde(cpt.getSolde());	metier.addOperation(o, request, a);metier.deleteOperation(o1.getId_operation());}
				else { if(o1.getMontant()-o.getMontant()>0){ o.setMontant(o1.getMontant()-o.getMontant());o.setDateValeur(dateFormat.format(new Date(date.getTime()+(1000*60*60*24))));o.setType("Versement");Compte cpt=metier.consulterCompte(o.getC().getId()) ;
				o.setSolde(cpt.getSolde());	metier.addOperation(o, request, a);metier.deleteOperation(o1.getId_operation());}
				else if(o1.getMontant()-o.getMontant()<0) { o.setDateValeur(dateFormat.format(new Date(date.getTime()-(1000*60*60*24))));
				o.setMontant(o.getMontant()-o1.getMontant()); Compte cpt=metier.consulterCompte(o.getC().getId()) ;
				o.setSolde(cpt.getSolde());	 metier.addOperation(o, request, a);metier.deleteOperation(o1.getId_operation());}
				else {
					metier.deleteOperation(o1.getId_operation());
				}}}
				else { if(ch1.equals("Versement")){
				  if(o.getMontant()-o1.getMontant()>0){ o.setMontant(o.getMontant()-o1.getMontant());o.setDateValeur(dateFormat.format(new Date(date.getTime()+(1000*60*60*24))));Compte cpt=metier.consulterCompte(o.getC().getId()) ;
					o.setSolde(cpt.getSolde());	metier.addOperation(o, request, a);metier.deleteOperation(o1.getId_operation());}
				else if(o.getMontant()-o1.getMontant()<0) { o.setDateValeur(dateFormat.format(new Date(date.getTime()-(1000*60*60*24))));
				o.setMontant(o1.getMontant()-o.getMontant()); o.setType("Retrait");Compte cpt=metier.consulterCompte(o.getC().getId()) ;
				o.setSolde(cpt.getSolde());	metier.addOperation(o, request, a);metier.deleteOperation(o1.getId_operation());}
				else { metier.deleteOperation(o1.getId_operation());}
					
				}
				else {
					o.setMontant(o.getMontant()+o1.getMontant());o.setDateValeur(dateFormat.format(new Date(date.getTime()-(1000*60*60*24))));Compte cpt=metier.consulterCompte(o.getC().getId()) ;
					o.setSolde(cpt.getSolde());	metier.addOperation(o, request, a);metier.deleteOperation(o1.getId_operation());
				}
				
					
		  }}
				request.getRequestDispatcher("Ajout_oper.jsp").forward(request, response);}
		  
		
	}

}
