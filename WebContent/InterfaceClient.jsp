<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("client")==null)
	response.sendRedirect("ClientLogin.jsp");
	
	response.setHeader("Cache-Control","no-cache");
	
	response.setHeader("Cache-Control","no-store");
	response.setDateHeader("Expires",0);
	response.setHeader("Pragma","no-cache");
	
	%>
<a href="LogoutClient.jsp">logout</a>
<p> salut client </p>
</body>
</html>