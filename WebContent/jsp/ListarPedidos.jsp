<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.PedidoCompra" %>
<%@page import="model.Categoria" %>
<%@page import="control.CategoriaBean" %>
<%@page import="control.PedidoCompraBean" %>
<%@page import="control.UsuarioBean" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/TabelaPedidoCompras.css" />
<script type="text/javascript">
<jsp:include page="../js/jquery-3.2.1.js"></jsp:include>
<jsp:include page="../js/botoesPedidoCompra.js"></jsp:include>
</script>
</head>
<body>
<%
	PedidoCompra pedidoCompra=new PedidoCompra();
	Categoria categoria=new Categoria();
	PedidoCompraBean pedidoCompraB=new PedidoCompraBean();
	CategoriaBean categoriaB=null;
	pedidoCompra.deletarPedidosSemItens();
	ArrayList<PedidoCompraBean> pedidos=pedidoCompra.mostrarTodos();
	if(((UsuarioBean)session.getAttribute("usuarioB")).getPrivilegio()==1){
	out.println("<table class=\"visualizarPedido2\">"+
							"<tr>"+
								"<td>Data inicio</td>"+
								"<td>Data fim</td>"+
								"<td>Usuário</td>"+
								"<td>Categoria</td>"+
								"<td>Visualizar</td>"+
								"<td>Excluir</td>"+
							"</tr>");
							for(int i=0; i<pedidos.size();i++){
								pedidoCompraB=pedidos.get(i);
								categoriaB=categoria.mostrarCategoriaPedido(pedidoCompraB);
					out.println("<tr class=\"dados\">"+
									"<td>"+pedidoCompraB.getDataInicio()+"</td>"+
									"<td>"+pedidoCompraB.getDataFim()+"</td>"+
									"<td>"+pedidoCompraB.getLoginUsuario()+"</td>"+
									"<td>"+categoriaB.getNome()+"</td>"+
									"<td><button class='view' name='"+pedidoCompraB.getId()+"'><a href='jsp/visualizarPedidoCompra.jsp'><img src='imagens/editar.png'></a></button></td>"+
									"<td><button class='excluir' name='"+pedidoCompraB.getId()+"'><a href='jsp/excluirPedidoCompra.jsp'><img src='imagens/excluir.png'></a></button></td>"+
								"</tr>");
								}
			out.println("</table>");
	}else{
		out.println("<table class=\"visualizarPedido2\">"+
								"<tr>"+
									"<td>Data inicio</td>"+
									"<td>Data fim</td>"+
									"<td>Usuário</td>"+
									"<td>Categoria</td>"+
									"<td>Visualizar</td>"+
								"</tr>");
								for(int i=0; i<pedidos.size();i++){
									pedidoCompraB=pedidos.get(i);
									categoriaB=categoria.mostrarCategoriaPedido(pedidoCompraB);
						out.println("<tr class=\"dados\">"+
										"<td>"+pedidoCompraB.getDataInicio()+"</td>"+
										"<td>"+pedidoCompraB.getDataFim()+"</td>"+
										"<td>"+pedidoCompraB.getLoginUsuario()+"</td>"+
										"<td>"+categoriaB.getNome()+"</td>"+
										"<td><button class='view' name='"+pedidoCompraB.getId()+"'><a href='jsp/visualizarPedidoCompra.jsp'><img src='imagens/editar.png'></a></button></td>"+
									"</tr>");
									}
				out.println("</table>");
		
	}
%>	
</body>
</html>