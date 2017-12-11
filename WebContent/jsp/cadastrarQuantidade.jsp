<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.PedidoCompra" %>
<%@page import="model.Item" %>
<%@page import="control.PedidoCompraBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="itemB" class="control.ItemBean" scope="page"/>
<jsp:setProperty name="itemB" property="qtd" param="qtd"/>
<%
	try{
		PedidoCompra pedidoCompra=new PedidoCompra();
		Item item=new Item();
		PedidoCompraBean pedidoB=pedidoCompra.ultimoPedidoCadastrado();
		itemB.setIdPedidoCompra(pedidoB.getId());
		itemB.setProduto(Integer.parseInt(request.getParameter("id")));
		item.inserir(itemB);
	}catch(Exception e){
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
<jsp:include page="mostrarProdutosCategoria.jsp"></jsp:include>
</body>
</html>