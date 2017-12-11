<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Usuario" %>
<%@page import="control.UsuarioBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	try{
		Usuario usuario=new Usuario();
		UsuarioBean usuarioB=new UsuarioBean();
		usuarioB.setLogin(request.getParameter("login"));
		usuarioB=usuario.encontrar(usuarioB);
		usuario.deletar(usuarioB);
		response.sendRedirect("jsp/VisualizarUsuarios.jsp");
	}catch(Exception e){
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
</body>
</html>