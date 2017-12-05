<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<jsp:include page="../css/PedidoEstiloForm.css"></jsp:include>
<jsp:include page="../css/Alerta.css"></jsp:include>
</style>
<title>Insert title here</title>
</head>
<body>
<%
out.println("<form class='Formulario' name='cadastrar' method='post' action='jsp/cadastrarPedido.jsp' id='cadastrar'>"+
				"<div class='alerta' id='alerta'>"+
					"<figure class='fechar' id='fechar'>"+
						"<img src='imagens/fechar.png'>"+
					"</figure>"+
					"<p>"+
						"Cadastrado com sucesso!"+
					"</p>"+
				"</div>"+
				"<label for='nome' class='labelCPedido' id='required'>Nome:</label>"+
				"<br/>"+
				"<input class='inputCPedido' type='text' required='required' placeholder='Nome do funcionário responsável pelo pedido' size='80' maxlength='80' name='nome'/>"+
				"<br/>"+
				"<label for='qtd' class='labelCPedido' id='required'>Quantidade:</label>"+
				"<br/>"+
				"<input id='qtd' class='inputCPedido' type='number' required='required' placeholder='Quantidade de itens' size='20' maxlength='20' name='qtd'/>"+
				"<br/>"+
				"<div id='itens'>"+
				"</div>"+
				"<label for='interno' class='labelCPedido' id='required'>Tipo de pedido:</label>"+
				"<br/>"+
				"<select class='inputCPedido'>"+
				"<option value='Interno' selected >Interno</option>"+
				"<option value='Externo'>Externo</option>"+
				"</select>"+
				"<br/>"+
				"<label for='dataFim' class='labelCPedido' id='required'>Prazo final do pedido:</label>"+
				"<br/>"+
				"<input class='inputCPedido' type='date' required='required'name='dataFim'/>"+
			"</form>");  
%>
</body>
</html>