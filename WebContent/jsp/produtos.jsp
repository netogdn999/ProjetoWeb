<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Categoria" %>
<%@page import="control.CategoriaBean" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/TabelaCategoria.css" />
<script type="text/javascript">
<jsp:include page="../js/jquery-3.2.1.js"></jsp:include>
<jsp:include page="../js/botoesSelecionarProduto.js"></jsp:include>
</script>
<title>Insert title here</title>
</head>
<body>
<%
Categoria categoria=new Categoria();
CategoriaBean categoriaB=new CategoriaBean();
ArrayList<CategoriaBean> categorias=categoria.mostrarTodas();
out.println("<table class=\"visualizarCategoria2\">"+
						"<tr>"+
							"<td>Nome</td>"+
							"<td>Selecionar</td>"+
						"</tr>");
						for(int i=0; i<categorias.size();i++){
							categoriaB=categorias.get(i);
				out.println("<tr class=\"dados\">"+
								"<td>"+categoriaB.getNome()+"</td>"+
								"<td><button class='selecionar' name='"+categoriaB.getId()+"'><a href='jsp/mostrarProdutosCategoria.jsp'><img src='imagens/editar.png'></a></button></td>"+
							"</tr>");
							}
		out.println("</table>"); 
%>
</body>
</html>