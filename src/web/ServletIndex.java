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


import metier.SingletonConnection;
import metier.User;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session =request.getSession();
		
	
	String	user1 =	request.getParameter("user");
	 String passe1=	request.getParameter("passe");
	
   User user=new User(user1,passe1);
	Connection conn=SingletonConnection.getConnection();
	PreparedStatement ps;
	try {
		ps = conn.prepareStatement("select * from administrateur where login='"+user1+"' and motDePasse='"+passe1+"' "); 
	ResultSet rs=ps.executeQuery() ;
	RequestDispatcher dispatcher = null ;
if(rs.next())
{   session.setAttribute("user",user);
	dispatcher= request.getRequestDispatcher("accueil.jsp");
dispatcher.forward(request,response) ;
}
else 
{
	

	response.sendRedirect("erreurlogin.jsp");

	} }
	
	
	catch (SQLException e) {
	e.printStackTrace();
}
		
	}
	
}
