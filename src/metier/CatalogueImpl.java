package metier;
import java.util.ArrayList;
import java.util.List ;

import javax.servlet.http.HttpServletRequest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CatalogueImpl  implements Catalogue{
	
	public Client getClient(String email)
	{ Client c=null;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from client where email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery() ;
			if(rs.next())
			{
				c=new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setAdresse(rs.getString("adresse"));
				c.setTelephone(rs.getString("telephone"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
				
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c==null) throw new RuntimeException("Client introuvable");
 return c ;
	}
	public Client getClientParId(int id)
	{ Client c=null;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from client where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery() ;
			if(rs.next())
			{
				c=new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setAdresse(rs.getString("adresse"));
				c.setTelephone(rs.getString("telephone"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
				
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c==null) throw new RuntimeException("Client introuvable");
 return c ;
	}

	public void addClient(Client c,HttpServletRequest request) {
		
		Connection conn=SingletonConnection.getConnection();
		
		try { 
			
			PreparedStatement PS =conn.prepareStatement("select * from client where email ='"+c.getEmail()+"' ");
			ResultSet RS=PS.executeQuery();
		
			if(RS.next())
			{
			//	System.out.println("Email deja utilisé ");
			request.setAttribute("alerte", " ** Email deja utilisé **");
			}
			else
			{
			
			PreparedStatement ps=conn.prepareStatement("insert into client(nom,prenom,adresse,telephone,email,password) values(?,?,?,?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getAdresse());
			ps.setString(4, c.getTelephone());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getPassword());
			ps.executeUpdate();
	
			
			ps.close();}
			PS.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Client> listClients() {
		List<Client> cls=new ArrayList<Client>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from client");
			ResultSet rs=ps.executeQuery() ;
			while(rs.next())
			{
				Client c=new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setAdresse(rs.getString("adresse"));
				c.setTelephone(rs.getString("telephone"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
				cls.add(c);
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;
	}
	public void deleteCompte(int id_compte) {
		deleteOperation1(id_compte);
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from  compte   where id_compte=?");
			ps.setLong(1, id_compte );
	
			
    ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void deleteOperation1(int id_compte)
	{
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from  operation   where id_compte=?");
			ps.setInt(1, id_compte );
	
			
    ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		public void versement_retrait (Operation o)
		{	Connection conn=SingletonConnection.getConnection();
		
		 int id_compte =o.getC().getId();
		 Compte C = getCompteById(id_compte);
		 System.out.println(id_compte);
		 double x=0;
		 try {
				PreparedStatement ps=conn.prepareStatement("update  compte set solde=? where id_compte=?");
				System.out.println(x);
				if(o.getType().equals("Versement"))
					
				{ x = C.getSolde()+o.getMontant();
				/*System.out.println(C.getSolde());
				System.out.println(o.getMontant());*/
				
				}
				else
					{x=C.getSolde()-o.getMontant();}
				
				//System.out.println(x);
				ps.setDouble(1, x);
				ps.setInt(2,id_compte );
				
				
	   ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
			
		}
	

	@Override
	public void updateClient(Client c) {

		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("update  client set nom=?,prenom=?,adresse=?,telephone=?,email=?,password=?  where id=?");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getAdresse());
			ps.setString(4, c.getTelephone());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getPassword());
			ps.setInt(7, c.getId());
ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClient(String email) {
		Connection conn=SingletonConnection.getConnection();
		
		
		Client C=getClient(email);
	int	id_client = C.getId();
		
		List<Compte> liste = getComptes(id_client );
		int i=0;
		for (Compte compte : liste)
		{
		  i++;
			deleteCompte(compte.getId());
			
		}
		
		try {
			PreparedStatement ps=conn.prepareStatement("delete from  client   where email=?");
			ps.setString(1, email);
	
			
    ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("hello");
		//deleteCompte(C.getId());
		
		
		
	}
	@Override
	public List<Client> listClientsParNom(String ch) {
		List<Client> cls=new ArrayList<Client>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from client where nom like ?");
			ps.setString(1,"%"+ch+"%") ;
			ResultSet rs=ps.executeQuery() ;
			while(rs.next())
			{
				Client c=new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setAdresse(rs.getString("adresse"));
				c.setTelephone(rs.getString("telephone"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
				cls.add(c);
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;
	}

	public void addCompte(Compte c,HttpServletRequest request, int codeCli) {
Connection conn=SingletonConnection.getConnection();
		
		try { 
			
	
			PreparedStatement ps=conn.prepareStatement("insert into compte(DateCreation,solde,id) values(?,?,?)");
			ps.setString(1, c.getDateCreation());
			ps.setDouble(2, c.getSolde());
			ps.setInt(3, codeCli);
			
			
			ps.executeUpdate();
	
			
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	
	public List<Compte> getComptes(int codeCli) {
		List<Compte> cls=new ArrayList<Compte>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from compte where id like ?");
        ps.setInt(1,codeCli);		
      ResultSet rs=ps.executeQuery() ;
			while(rs.next())
			{
				Compte c=new Compte();
				Client cl=new Client();
				c.setId(rs.getInt("id_compte"));
				c.setDateCreation(rs.getString("DateCreation"));
				c.setSolde(rs.getDouble("solde"));
				
				cl= getClientParId(codeCli);
				c.setC(cl);
				cls.add(c);
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;

	}
	public Compte getCompteById(int id_compte)
	{ Connection conn=SingletonConnection.getConnection();
	
	Compte c=null;
	try {
		PreparedStatement ps=conn.prepareStatement("select * from compte where id_compte=?");
		ps.setInt(1, id_compte);
		ResultSet rs=ps.executeQuery() ;
		if(rs.next())
		{
			c=new Compte();
		 //	c.setId(rs.getInt("id"));
			c.setId(rs.getInt("id_compte"));
			c.setSolde(rs.getDouble("solde"));
			
		
			
			
			
		}
		
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return c;
	
	
	}

	public Compte consulterCompte(int codeCompte) {
		
		Compte c =new Compte() ;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from compte where id_Compte like ?");
        ps.setInt(1,codeCompte);		
      ResultSet rs=ps.executeQuery() ;
			while(rs.next())
			{
				
				Client cl=new Client();
				c.setId(rs.getInt("id_compte"));
				c.setDateCreation(rs.getString("DateCreation"));
				c.setSolde(rs.getDouble("solde"));
				
				int codeCli=rs.getInt("id");
				cl= getClientParId(codeCli);
				c.setC(cl);
				
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c==null) throw new RuntimeException("Compte introuvable");
		
		return c;
	}
	
	public List<Compte> listComptes() {
		List<Compte> cls=new ArrayList<Compte>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from compte");
			ResultSet rs=ps.executeQuery() ;
			while(rs.next())
			{
				Compte c=new Compte();
				c.setId(rs.getInt("id_compte"));
c.setDateCreation(rs.getString("DateCreation"));			
c.setSolde(rs.getDouble("solde"));		

int a=rs.getInt("id") ;
 Client clt= getClientParId(a); 
 c.setC(clt);
				cls.add(c);
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;

	}
	@Override
	public void updateCompte(double solde ,int codeCompte) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("update  compte set solde=? where id_compte=?");
			ps.setDouble(1, solde);
			ps.setInt(3, codeCompte);
			
ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void addOperation(Operation o, HttpServletRequest request, int codeCompte) {
Connection conn=SingletonConnection.getConnection();
		
		try { 
			
	
			PreparedStatement ps=conn.prepareStatement("insert into operation(type,montant,dateOperation,dateValeur,solde,id_compte) values(?,?,?,?,?,?)");
			ps.setString(1, o.getType());
			ps.setDouble(2, o.getMontant());
			ps.setString(3,o.getDateOperation());
			ps.setString(4, o.getDateValeur());
			ps.setDouble(5, o.getSolde());
			ps.setInt(6, codeCompte);
			
			
			ps.executeUpdate();
	
			
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	public List<Operation> listOperations(int codeCompte) {
		List<Operation> cls=new ArrayList<Operation>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from operation where id_compte like ?");
        ps.setInt(1,codeCompte);		
      ResultSet rs=ps.executeQuery() ;
			while(rs.next())
			{   Operation o= new Operation() ;
				Compte c=new Compte();
				
				o.setId_operation(rs.getInt("id_operation"));
			 o.setDateOperation(rs.getString("dateOperation"));
			 o.setDateValeur(rs.getString("dateValeur"));
				o.setMontant(rs.getDouble("montant"));
				o.setType(rs.getString("type"));
				o.setSolde(rs.getDouble("solde"));
			c=consulterCompte(codeCompte);	
				o.setC(c);
				cls.add(o);
				
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;
	}
	public void deleteOperation(int id_operation) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from  operation   where id_operation=?");
			ps.setLong(1, id_operation );
	
			
    ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Operation TrouverOperation(String date,int id) {
		
	Operation o =new Operation() ;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from operation where dateOperation=? and id_compte =?");
        ps.setString(1,date);
        ps.setInt(2,id);
      ResultSet rs=ps.executeQuery() ;
			while(rs.next())
			{  
				Compte c=new Compte();
				
				o.setId_operation(rs.getInt("id_operation"));
			 o.setDateOperation(rs.getString("dateOperation"));
			 o.setDateValeur(rs.getString("dateValeur"));
				o.setMontant(rs.getDouble("montant"));
				o.setType(rs.getString("type"));
				o.setSolde(rs.getDouble("solde"));
			c=consulterCompte(id);	
				o.setC(c);
				
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

}
