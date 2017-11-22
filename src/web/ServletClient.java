package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.ConnexionClient;
import metier.SingletonConnection;

@WebServlet("/ServletClient")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
				
				HttpSession session =request.getSession();
				
				request.getRequestDispatcher("ClientLogin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 
				
				
				HttpSession session =request.getSession();
				
			
			String	user1 =	request.getParameter("user");
			 String passe1=	request.getParameter("passe");
			
		   ConnexionClient client=new   ConnexionClient(user1,passe1);
			Connection conn = SingletonConnection.getConnection();
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement("select * from client where email='"+user1+"' and password='"+passe1+"' "); 
			ResultSet rs=ps.executeQuery() ;
			RequestDispatcher dispatcher = null ;
		if(rs.next())
		{   session.setAttribute("client",client);
			dispatcher= request.getRequestDispatcher("InterfaceClient.jsp");
		dispatcher.forward(request,response) ;
		}
		else 
		{
			

			request.setAttribute("alerte","Veuillez ressayer : Email et/ou Password Incorrect(s)");
			dispatcher= request.getRequestDispatcher("ClientLogin.jsp");
			dispatcher.forward(request,response) ;

			} }
			
			
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

}
}

