<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Categoria"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="categoriaB" class="control.CategoriaBean" scope="page"></jsp:useBean>
<jsp:setProperty name="categoriaB" property="nome" param="nome"/>
<%
	try{
		Categoria categoria=new Categoria();
		categoria.inserir(categoriaB);
	}catch(Exception e){
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
</body>
</html>