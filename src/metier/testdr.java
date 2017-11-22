package metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
public abstract class testdr {

	private static final HttpServletRequest HttpServletRequest = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Catalogue metier = new CatalogueImpl();

List<Operation> op = new ArrayList<Operation>() ;
op=metier.listOperations(29) ;
for( Operation o : op)
{
	System.out.println(o.getId_operation());
}

}}