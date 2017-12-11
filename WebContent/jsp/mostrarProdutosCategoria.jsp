<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Produto"%>
<%@page import="control.ProdutoBean"%>
<%@page import="control.CategoriaBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/TabelaProduto.css" />
<script type="text/javascript">
<jsp:include page="../js/jquery-3.2.1.js"></jsp:include>
<jsp:include page="../js/botoesQuantidade.js"></jsp:include>
</script>
</head>
<body>
<%
Produto produto=new Produto();
ProdutoBean produtoB=new ProdutoBean();
CategoriaBean categoriaB=new CategoriaBean();
categoriaB.setId(Integer.parseInt(request.getParameter("id")));
ArrayList<ProdutoBean> produtos=produto.mostrarProdutosCategoria(categoriaB);
out.println("<table class=\"visualizarProduto2\">"+
						"<tr>"+
							"<td>Nome</td>"+
							"<td>Marca</td>"+
							"<td>Selecionar</td>"+
						"</tr>");
						for(int i=0; i<produtos.size();i++){
							produtoB=produtos.get(i);
				out.println("<tr class=\"dados\">"+
								"<td>"+produtoB.getNome()+"</td>"+
								"<td>"+produtoB.getMarca()+"</td>"+
								"<td><button class='selecionar' name='"+produtoB.getId()+"'><a href='jsp/AdicionarQuantidade.jsp'><img src='imagens/editar.png'></a></button></td>"+
							"</tr>");
							}
		out.println("</table>"); 
%>
</body>
</html>