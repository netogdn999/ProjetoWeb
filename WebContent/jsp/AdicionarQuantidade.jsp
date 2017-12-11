<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<jsp:include page="../css/QuantidadeEstiloForm.css"></jsp:include>
<jsp:include page="../css/Alerta.css"></jsp:include>
</style>
<title>Insert title here</title>
</head>
<body>
<%
out.println("<form class='Formulario' name='cadastrar' method='post' action='jsp/cadastrarQuantidade.jsp' id='cadastrar'>"+
				"<div class='alerta' id='alerta'>"+
					"<figure class='fechar' id='fechar'>"+
						"<img src='imagens/fechar.png'>"+
					"</figure>"+
					"<p>"+
						"Cadastrado com sucesso!"+
					"</p>"+
				"</div>"+
				"<label for='qtd' class='labelCQuantidade' id='required'>Quantidade:</label>"+
				"<br/>"+
				"<input class='inputCQuantidade' type='number' required='required' placeholder='Digite a quantidade' size='80' maxlength='80' name='qtd'/>"+
			"</form>");  
%>
</body>
</html>