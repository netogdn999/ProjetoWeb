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
				"<label for='dataFim' class='labelCPedido' id='required'>Prazo final do pedido:</label>"+
				"<br/>"+
				"<input class='inputCPedido' type='date' required='required'name='dataFim'/>"+
			"</form>");  
%>
</body>
</html>