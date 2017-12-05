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
				"<label for='nome' class='labelCUsuario' id='required'>Nome:</label>"+
				"<br/>"+
				"<input class='inputCUsuario' type='text' required='required' placeholder='Nome do funcionário' size='80' maxlength='80' name='nome'/>"+
				"<br/>"+
				"<label for='login' class='labelCUsuario' id='required'>Login:</label>"+
				"<br/>"+
				"<input class='inputCUsuario' type='text' required='required' placeholder='Login do usuário' size='80' maxlength='80' name='login'/>"+
				"<br/>"+
				"<label for='senha' class='labelCUsuario' id='required'>Senha:</label>"+
				"<br/>"+
				"<input class='inputCUsuario' type='text' required='required' placeholder='Senha do usuário' size='80' maxlength='80' name='senha'/>"+
				"<br/>"+
				"<label for='setor' class='labelCUsuario' id='required'>Setor:</label>"+
				"<br/>"+
				"<input class='inputCUsuario' type='text' required='required' placeholder='Setor ao qual o usuário pertence' size='80' maxlength='80' name='setor'/>"+
			"</form>");  
%>
</body>
</html>