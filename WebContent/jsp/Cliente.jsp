<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<jsp:include page="../css/ClienteEstiloForm.css"></jsp:include>
<jsp:include page="../css/Alerta.css"></jsp:include>
</style>
<title>Insert title here</title>
</head>
<body>
<%
out.println("<form class='Formulario' name='cadastrar' method='post' action='jsp/cadastrarProduto.jsp' id='cadastrar'>"+
				"<div class='alerta' id='alerta'>"+
					"<figure class='fechar' id='fechar'>"+
						"<img src='imagens/fechar.png'>"+
					"</figure>"+
					"<p>"+
						"Cadastrado com sucesso!"+
					"</p>"+
				"</div>"+
				"<label for='nomeProduto' class='labelCCliente' id='required'>Nome:</label>"+
				"<br/>"+
				"<input class='inputCCliente' type='text' required='required' placeholder='Nome do produto' size='80' maxlength='80' name='nomeProduto'/>"+
				"<br/>"+
				"<label for='marca' class='labelCCliente' id='required'>Marca:</label>"+
				"<br/>"+
				"<input class='inputCCliente' type='text' required='required' placeholder='Marca do seu produto' size='80' maxlength='80' name='marca'/>"+
				"<br/>"+
				"<label for='Categoria' class='labelCCliente' id='required'>Categoria:</label>"+
				"<br/>"+
				"<select size='1' name='D1' class='comboBox'>"+
					"<option selected value='Selecione'>Categoria!</option>");

		out.println("<option value='2000'>2000</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2001'>2001</option>"+
					"<option value='2002'>2002</option>");
					
	out.println("</select>"+
			"</form>");  
%>
</body>
</html>