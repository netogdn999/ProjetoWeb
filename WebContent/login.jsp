<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Página de login</title>
<meta name="description" content="" />
<meta name="robots" content="index, follow" />
<link rel="stylesheet" type="text/css" href="css/estiloLogin.css" />
<script rel="text/script" src="js/jquery-3.2.1.js"></script>
<script rel="text/script" src="js/scriptLogin.js" charset="UTF-8"></script>

</head>
<body>
	<div class="popupExt" id="popupExt">
		<img class="fechar" src="imagens/fechar2.png">
		<div class="popup">
			<p class="aviso">
				senha ou usuário inválidos.
			</p>
		</div>
	</div>
	<section class="corpo">
	<div class="telaLogin">
		<figure class="logo"> <img src="imagens/logo_2.png" /> </figure>
		<form id="formulario" name="formulario" method="post" action="jsp/Logar.jsp">
			<label class="label" for="usuario">Usuário:</label>
			<br/>
			<input id="usuario" class="input" type="text" size="30" maxlength="20" name="usuario"/>
			<br/>
			<p id="campo1">Campo obrigatório</p>
			<label class="label" for="senha">Senha:</label>
			<br/> 
			<input id="senha" class="input" type="password" size="30" maxlength="12" name="senha"/> 
			<br/>
			<p id="campo2">Campo obrigatório</p>
			<br/>
			<a class="label" id="cadastrar" href="CadastroFornecedor.jsp">cadastrar usuario</a>
			<div id="botao" class="botao">Login</div>
		</form>
	</div>
	</section>
</body>
</html>