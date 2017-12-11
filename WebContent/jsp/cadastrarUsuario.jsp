<%@page import="model.LoginInvalidoException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="usuarioB" class="control.UsuarioBean" scope="page"/>
<jsp:setProperty name="usuarioB" property="nome" param="nome"/>
<jsp:setProperty name="usuarioB" property="login" param="login"/>
<jsp:setProperty name="usuarioB" property="senha" param="senha"/>
<jsp:setProperty name="usuarioB" property="setor" param="setor"/>

<%
	try{
		usuarioB.setPrivilegio(2);
		Usuario usuario=new Usuario();
		usuario.inserir(usuarioB);
	}catch(Exception e){
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
</body>
</html>