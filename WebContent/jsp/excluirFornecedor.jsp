<%@page import="model.Fornecedor"%>
<%@page import="control.FornecedorBean"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>excluirFornecedor</title>
</head>
<body>
<%
	try{
		Fornecedor fornecedor=new Fornecedor();
		Usuario usuario=new Usuario();
		FornecedorBean fornecedorB=new FornecedorBean();
		fornecedorB.setId(Integer.parseInt(request.getParameter("id")));
		fornecedor.deletar(fornecedorB);
		usuario.deletar(usuario.encontrar(fornecedorB));
	}catch(Exception e){
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
</body>
</html>