<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Página de login</title>
<meta name="description" content="" />
<meta name="robots" content="index, follow" />
<link rel="stylesheet" type="text/css" href="../css/CadastroEstilo.css" />
<script rel="text/script" src="../js/jquery-3.2.1.js"></script>
<script rel="text/script" src="../js/scriptLogin.js" charset="UTF-8"></script>

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
		<figure class="logo"> <img src="../imagens/logo_2.png" /> </figure>
		<form id="formulario" name="login" method="post" action="">
			<label class="label" for="usuario">Usuário:</label>
			<br/>
			<input id="usuario" class="input" type="text" size="20" maxlength="20" name="usuario"/>
			<br/>
			<label class="label" for="senha">Senha:</label>
			<br/>
			<input id="senha" class="input" type="text" size="20" maxlength="14" name="senha"/>
			<br/>
			<label class="label" for="nivel">Nível de acesso:</label>
			<br/>
			<select size='1' name='D1' class='comboBox'>
				<option selected value='Fornecedor'>Fornecedor</option>
				<option value='Funcionário'>Funcionário</option>
				<option value='Gerente'>Gerente</option>
			</select>
			<div id="botao" class="botao">Cadastrar</div>
		</form>
	</div>
	</section>
</body>
</html>