<%@page import="model.LoginInvalidoException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="usuarioB" class="control.UsuarioBean" scope="session"/>
<jsp:setProperty name="usuarioB" property="login" param="usuario"/>
<jsp:setProperty name="usuarioB" property="senha" param="senha"/>
<%
	Usuario usuario=new Usuario();
	try{
		usuario.entrar(usuarioB);
		session.setAttribute("usuarioB", usuario.encontrar(usuarioB));
		response.sendRedirect("../index.html");
	}catch(LoginInvalidoException e){
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
</body>
</html>