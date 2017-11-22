<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    body {
	background-image: url(images/5.jpg);
	background-repeat: no-repeat;
background-position: center ;
	
	font-family: calibri;
	font-size: 13px;
	color: white;
}
</style>
</head>
<body>

<br><br><br><br><br><br><br><br>


<form action="ServletClient" method="post" name="Form1">
  <table width="259" border="0" align="center">
    <tr>
      <td height="27" colspan="2" align="center" valign="middle">AUTHENTIFICATION</td>
    </tr>
    <tr>
      <td width="117">Email Client</td>
      <td width="132"><input type="text" name="user" id="user" /></td>
    </tr>
    <tr>
      <td>Mot de passe</td>
      <td><input type="password" name="passe" id="passe" /></td>
    </tr>

		<tr>
			<td><input type="hidden" name="bouton" value="add"></td>
			<td> <input type="submit"  name="button" id="button" value="Se connecter" /></td>
		</tr>
		<tr>
			<td> <% String alerte = (String)request.getAttribute("alerte");
			  if(alerte != null)
				  out.print(alerte);
			
			%>
</td>
		</tr>
		
		
</table>
</form>

</body>
</html>