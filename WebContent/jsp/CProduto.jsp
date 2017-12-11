<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Produto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="produtoB" class="control.ProdutoBean" scope="page"></jsp:useBean>
<jsp:setProperty name="produtoB" property="nome" param="nome"/>
<jsp:setProperty name="produtoB" property="marca" param="marca"/>
</head>
<body>
<% 
	try{
		Produto produto= new Produto();
		produtoB.setIdCategoria(Integer.parseInt(request.getParameter("id")));
		produto.inserir(produtoB);
	}catch(Exception e){
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
</body>
</html>