<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Item" %>
<%@page import="control.ItemBean" %>
<%@page import="control.PedidoCompraBean" %>
<%@page import="model.Produto" %>
<%@page import="control.ProdutoBean" %>
<%@page import="control.UsuarioBean" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/TabelaItem.css" />
<style type="text/css">
<jsp:include page="../css/ItemEstiloForm.css"></jsp:include>
<jsp:include page="../css/Alerta.css"></jsp:include>
</style>
<script type="text/javascript">
<jsp:include page="../js/jquery-3.2.1.js"></jsp:include>
<jsp:include page="../js/botoesPedidoCompra.js"></jsp:include>
</script>

</head>
<body>
<%
	if(((UsuarioBean)session.getAttribute("usuarioB")).getPrivilegio()==1){
	Item item=new Item();
	ItemBean itemB=null;
	PedidoCompraBean pedidoB=new PedidoCompraBean();
	Produto produto=new Produto();
	ProdutoBean produtoB=new ProdutoBean();
	pedidoB.setId(Integer.parseInt(request.getParameter("id")));
	ArrayList<ItemBean> itens=item.mostrarItensPedido(pedidoB);
		out.println("<table class=\"visualizarItem2\">"+
				"<tr>"+
					"<td>Nome</td>"+
					"<td>Marca</td>"+
					"<td>Quantidade</td>"+
					"<td>Dar lance</td>"+
				"</tr>");
				for(int i=0; i<itens.size();i++){
					itemB=itens.get(i);
					produtoB.setId(itemB.getIdProduto());
					produtoB=produto.encontrar(produtoB);
		out.println("<tr class=\"dados\">"+
						"<td>"+produtoB.getNome()+"</td>"+
						"<td>"+produtoB.getMarca()+"</td>"+
						"<td>"+itemB.getQtd()+"</td>"+
						"<td><button class='view' name='"+itemB.getId()+"'><a href='jsp/visualizarPedidoCompra.jsp'><img src='imagens/editar.png'></a></button></td>"+
					"</tr>");
					}
		out.println("</table>");
	}else if(((UsuarioBean)session.getAttribute("usuarioB")).getPrivilegio()==3){
	Item item=new Item();
	ItemBean itemB=null;
	PedidoCompraBean pedidoB=new PedidoCompraBean();
	Produto produto=new Produto();
	ProdutoBean produtoB=new ProdutoBean();
	pedidoB.setId(Integer.parseInt(request.getParameter("id")));
	ArrayList<ItemBean> itens=item.mostrarItensPedido(pedidoB);
		out.println("<form class='Formulario' name='cadastrar' method='post' action='jsp/CadastrarLance.jsp' id='cadastrar'>"+
				"<div class='alerta' id='alerta'>"+
					"<figure class='fechar' id='fechar'>"+
						"<img src='imagens/fechar.png'>"+
					"</figure>"+
					"<p>"+
						"Cadastrado com sucesso!"+
					"</p>"+
				"</div>"+
				"<label for='qtdParcelas' class='labelCItem' id='required'>Quantidade de parcelas:</label>"+
				"<br/>"+
				"<input class='inputCItem' type='text' required='required' placeholder='Digite a quantidade de parcelas' size='80' maxlength='80' name='qtdParcelas'/>"+
				"<br/>"+
				"<label for='dataEntrega' class='labelCItem' id='required'>Data da entrega:</label>"+
				"<br/>"+
				"<input class='inputCItem' type='date' required='required' name='dataEntrega'/>"+
				"<br/>");
				for(int i=0; i<itens.size();i++){
					itemB=itens.get(i);
					produtoB.setId(itemB.getIdProduto());
					produtoB=produto.encontrar(produtoB);
					%>
					<label for='nome' class='labelCItem1' id='required'>Nome:</label>
					<label for='marca' class='labelCItem1' id='required'>Marca:</label>
					<label for='qtd' class='labelCItem1' id='required'>Quantidade:</label>
					<label for='valor' class='labelCItem2' id='required'>Valor:</label>
					<br/>
					<input class='inputCItem' type='text' required='required' size='20' maxlength='80' disabled='' name='nome' value='<%=produtoB.getNome()%>'/>
					<input class='inputCItem' type='text' required='required' size='20' maxlength='80' disabled='' name='marca' value='<%=produtoB.getMarca()%>'/>
					<input class='inputCItem' type='text' required='required' size='20' maxlength='80' disabled='' name='Quantidade' value='<%=itemB.getQtd()%>'/>
					<input class='inputCItem' type='text' required='required' placeholder='Digite o valor total desse item' size='20' maxlength='80' name='valor'/>
					<br/>
				<%}%>
			</form>
<%	}
%>
</body>
</html>