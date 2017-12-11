<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<jsp:include page="../css/ProdutoEstiloForm.css"></jsp:include>
<jsp:include page="../css/Alerta.css"></jsp:include>
</style>
</head>
<body>
<%
out.println("<form class='Formulario' name='cadastrar' method='post' action='jsp/CProduto.jsp?id="+request.getParameter("id")+"' id='cadastrar'>"+
				"<div class='alerta' id='alerta'>"+
					"<figure class='fechar' id='fechar'>"+
						"<img src='imagens/fechar.png'>"+
					"</figure>"+
					"<p>"+
						"Cadastrado com sucesso!"+
					"</p>"+
				"</div>"+
				"<label for='nome' class='labelCProduto' id='required'>Nome:</label>"+
				"<br/>"+
				"<input class='inputCProduto' type='text' required='required' placeholder='Nome do produto' size='80' maxlength='80' name='nome'/>"+
				"<br/>"+
				"<label for='marca' class='labelCProduto' id='required'>Marca:</label>"+
				"<br/>"+
				"<input class='inputCProduto' type='text' required='required' placeholder='Marca do produto' size='80' maxlength='80' name='marca'/>"+
			"</form>");  
%>
</body>
</html>