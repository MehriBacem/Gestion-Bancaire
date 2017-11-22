<html>
<head>

<meta charset="iso-8859-1"/>
<title> Validation des données </title>
<style type="text/css">
    body {
	background-image: url(images/wassim.png);
   
	margin-left: 250px;
		margin-right: 250px;
	font-family: calibri;
	font-size: 13px;
	color: white ;
}
</style>

<script language=javascript>

	
	//Fonction 2:
	function validation()
	{
	
		if(document.formulaire.nom.value == "")
		{
			alert("Entrez votre nom, SVP !");
			return false;
		}
		if(document.formulaire.prenom.value == "")
		{
			alert("Entrez votre Prenom , SVP !");
			return false;
		}
		if(document.formulaire.adress.value == "")
		{
			alert("Entrez votre  Adresse , SVP !");
			return false;
		}
		if(document.formulaire.telephone.value == "")
		{
			alert("Entrez votre numero , SVP !");
			return false;
		}
		if(document.formulaire.adresse.value == "")
		{
			alert("Entrez votre adresse mail, SVP !");
			return false;
		}
		if(document.formulaire.motDePasse1.value == "")
		{
			alert("Entrez votre mot de passe, SVP !");
			return false;
		}
		if(document.formulaire.motDePasse2.value == "")
		{
			alert("Entrez votre mot de passe une autre fois , SVP !");
			return false;
		}
	
		adresse = document.formulaire.adresse.value;
		taille = document.formulaire.adresse.value.length;

 		
		validelog = false;
		validedom = false;
		valideext = false;

 
		arob = adresse.lastIndexOf("@");
		login = adresse.substring(0,arob);
 
		pointfinal = adresse.lastIndexOf(".");
		extension = adresse.substring(pointfinal,taille);
 
		domaine = adresse.substring(arob+1,pointfinal);

 		/* un login doit avoir toujours plus de 2 caractères, on fait le test */
		if ( login.length > 2 ) 
		{
			validelog = true;
 		}
		else 
		{
			validelog = false;
		}
 		/* un domaine a toujours plus de 1 caractère, on fait le test */
		if ( domaine.length > 1 ) 
		{
			validedom = true;
 		}
		else 
		{
 			
 			validelog = false;
		}

  		/* une extension a toujours 2 ou 3 caractères, on fait le test */
 		if ( pointfinal > -1 && (extension.length == 3 || extension.length == 4) ) 
		{
 			valideext = true;
 		}
		else 
		{
			valideext = false;
 		}

 		/* les trois variables doivent etre vraies pour valider l'adresse mail saisie*/
 		if ( validelog == true && validedom == true && valideext == true ) 
		{
 			mot_de_passe1 = document.formulaire.motDePasse1.value;
 			mot_de_passe2 = document.formulaire.motDePasse2.value;

 			if(mot_de_passe1 != mot_de_passe2)
 			{
 				alert("Les deux mots de passe que vous venez de saisir sont différents ! ");
 				return false;
 			}

 			else
 			{
 				return true;
 			}
 		}
		else 
		{
			alert('Ceci n\'est pas une adresse e-mail valide.');
			return false;
		}
 		

	}

</script>
<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>


</head>




<body  id="page" onload="MM_preloadImages('images/m_01.png','images/m_02.png','images/m_03.png','images/m_04.png','images/accuei1.png')">
 <% 
if(session.getAttribute("user")==null)
	response.sendRedirect("index.jsp");
	
	response.setHeader("Cache-Control","no-cache");
	
	response.setHeader("Cache-Control","no-store");
	response.setDateHeader("Expires",0);
	response.setHeader("Pragma","no-cache");
	
	%>
 </br>
 </br>
 
 <div >
 <table width="505" border="0" align="center">
    <tr>
    <td> </td>
      <td width="107"  ><a href="logout.jsp">Deconnexion</a></td>
    </tr>
  </table>
  </div>
  </br>
  </br>
<div id="bannier" align="center">
  <div id="menucon">
 
  <a href="AfficherClient.jsp" title="Liste des clients de la banque" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image1','','images/m_01.png',1)"><img src="images/MM (1).png" name="Image1" width="72" height="50" border="0" id="Image1" /></a>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  <a href="compte.jsp" title="Liste des comptes de la banque" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image3','','images/m_03.png',1)"><img src="images/MM (3).png" name="Image3" width="81" height="50" border="0" id="Image3" /></a>
  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  <a href="operation.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image4','','images/m_04.png',1)"><img src="images/MM (4).png" name="Image4" width="104" height="50" border="0" id="Image4" /></a>
  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  <a href="accueil.jsp" title="Retour à la page d'accueil)" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image5','','images/accuei1.png',1)"><img src="images/accueil.png" name="Image5" width="41" height="40" border="0" id="Image5" /></a>
  </div>
</br>
</br>
</br>
</br>
</br>
</br>



<form method=post action="controleurServlet?page=VueClient.jsp&action1=AjouterClient" name="formulaire" onsubmit="javascript: return validation();">
<fieldset>
<legend><h3>Client</h3> </legend>
<table align="center">
<tr>
<td><label for=nom>Saisissez votre Nom : </label></td>
<td><input type=text name=nom id=nom size=20 /></td>
</tr>
<tr>
<td><label for=nom>Saisissez votre Prenom : </label></td>
<td><input type=text name=prenom id=prenom size=20 /></td>
</tr>
<tr>
<td><label for=nom>Saisissez votre Adresse : </label></td>
<td><input type=text name=adress id=adress size=20 /></td>
</tr>
<tr>
<td><label for=nom>Saisissez votre Telephone : </label></td>
<td><input type=text name=telephone id=Telephone size=20 /></td>
</tr>

<tr>
<td><label for=pass1>Saisissez votre mot de passe : </label></td>
<td><input type=password name=motDePasse1 id=pass1 size=20 /> </td>
</tr>
<tr>
<td><label for=pass2>Re-saisissez votre mot de passe : </label></td>
<td><input type=password name=motDePasse2 id=pass2 size=20 /> </td>
</tr>
<tr>
<td><label for=adresse>Saisissez votre adresse mail : </label></td>
<td><input type=text name=adresse id=adresse size=20 /></td>
<td> <font color="white" size="4px"><%    
    String msg=(String)request.getAttribute("alerte");
    if(msg!=null)
    {
out.println(msg);
    } %></font></font> </td>
</tr>
</table>
</fieldset>

<input type=submit value=Envoyer />
<input type=reset value=Annuler />
</center>
</form>
</center>
</body>
</html>