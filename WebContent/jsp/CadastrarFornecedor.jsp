<%@page import="model.Fornecedor"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="fornecedorB" class="control.FornecedorBean" scope="page"/>
<jsp:useBean id="usuarioB" class="control.UsuarioBean" scope="page"/>
<jsp:setProperty name="usuarioB" property="login" param="usuario"/>
<jsp:setProperty name="usuarioB" property="senha" param="senha"/>
<jsp:setProperty name="usuarioB" property="nome" param="responsavel"/>
<jsp:setProperty name="fornecedorB" property="nomeFantasia" param="nomeFantasia"/>
<jsp:setProperty name="fornecedorB" property="razaoSocial" param="razaoSocial"/>
<jsp:setProperty name="fornecedorB" property="endereco" param="endereco"/>
<jsp:setProperty name="fornecedorB" property="cep" param="cep"/>
<jsp:setProperty name="fornecedorB" property="telefone1" param="numero1"/>
<jsp:setProperty name="fornecedorB" property="telefone2" param="numero2"/>
<jsp:setProperty name="fornecedorB" property="email" param="email"/>
<jsp:setProperty name="fornecedorB" property="cnpj" param="cnpj"/>

<%
try{
		usuarioB.setPrivilegio(3);
		usuarioB.setSetor("Fornecedor");
		fornecedorB.setAutenticado(false);
		Fornecedor fornecedor= new Fornecedor();
		fornecedor.inserir(fornecedorB);
		usuarioB.setIdFornecedor(fornecedor.ultimoFornecedorCadastrado().getId());
		Usuario usuario=new Usuario();
		usuario.inserir(usuarioB);
	}catch(Exception e){
		out.println("<h1>"+fornecedorB.getNomeFantasia()+"</h1>");
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
</body>
</html>