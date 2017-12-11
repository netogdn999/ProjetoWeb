<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Página de login</title>
<meta name="description" content="" />
<meta name="robots" content="index, follow" />
<link rel="stylesheet" type="text/css" href="css/CadastroEstilo.css" />
<script rel="text/script" src="js/jquery-3.2.1.js" charset="UTF-8"></script>
<script rel="text/script" src="js/scriptForm.js" charset="UTF-8"></script>
<script rel="text/script" src="js/jquery-form.js" charset="UTF-8"></script>
<script rel="text/script" src="js/scriptLogin.js" charset="UTF-8"></script>
<script rel="text/script" src="js/ScriptCadastro.js" charset="UTF-8"></script>
</head>
<body>
	<div class="popupExt" id="popupExt">
		<img class="fechar" src="imagens/fechar2.png">
		<div class="popup">
			<p class="aviso">
				dados invalidos.
			</p>
		</div>
	</div>
	<section class="corpo">
	<div class="telaLogin">
		<figure class="logo"> <img src="imagens/logo_2.png" /></figure>
		<form class='Formulario' name='cadastrar' method='post' action='jsp/CadastrarFornecedor.jsp' id='cadastrar'>
			<label for='usuario' class='labelCUsuario' id='required'>Usuário:</label>
			<label for='senha' class='labelCSenha' id='required'>Senha:</label>
			<br/>
			<input id="usuario" class='inputCUsuario' type='text' required='required' placeholder='Nome de usuario' size='20' maxlength='20' name='usuario'/>
			<input id="senha" class='inputCSenha' type='text' required='required' placeholder='Senha do usuario' size='20' maxlength='20' name='senha'/>
			<br/>
			<label for='nomeResp' class='labelCFornecedor' id='required'>Nome do responsável:</label>
			<br/>
			<input id="nomeResp" class='inputCFornecedor' type='text' required='required' placeholder='Nome do responsável pela empresa' size='80' maxlength='80' name='responsavel'/>
			<br/>
			<label for='nomeFantasia' class='labelCFornecedor' id='required'>Nome fantasia:</label>
			<br/>
			<input id="nomeFantasia" class='inputCFornecedor' type='text' required='required' placeholder='Nome fantasia da sua empresa' size='80' maxlength='80' name='nomeFantasia'/>
			<br/>
			<label for='razaoSocial' class='labelCFornecedor'>Razão social:</label>
			<br/>
			<input class='inputCFornecedor' type='text' required='required' placeholder='Razão social da sua empresa' size='80' maxlength='80' name='razaoSocial'/>
			<br/>
			<label for='endereco' class='labelCFornecedor1' id='required'>Endereco:</label>
			<label for='cep' class='labelCFornecedor' id='required'>CEP:</label>
			<br/>
			<input class='inputCFornecedor1' type='text' required='required' placeholder='seu endereco com o prefixo(Av.,Rua,etc...)' size='60' maxlength='100' name='endereco''/>
			<input class='inputCFornecedor' type='text' required='required' placeholder='00000-000' size='6' maxlength='6' name='cep'/>
			<br/>
			<label for='numero1' class='labelCFornecedorT' id='required'>Telefone1:</label>
			<label for='numero2' class='labelCFornecedor'>Telefone2:</label>
			<br/>
			<input class='inputCFornecedorT' type='tel' required='required' size='15' maxlength='13' name='numero1' placeholder='99 99999-9999' onkeypress="formatar('## #####-####', this)"/>
			<input class='inputCFornecedor' type='tel' size='15' maxlength='13' name='numero2' placeholder='99 99999-9999' onkeypress="formatar('## #####-####', this)"/>
			<br/>
			<label for='email' class='labelCFornecedor' id='required'>E-mail:</label>
			<br/>
			<input class='inputCFornecedor' type='text' placeholder='seuemail@gmail.com' size='80' maxlength='100' name='email'/>
			<br/>
			<label for='cnpj' class='labelCFornecedor' id='required'>C.N.P.J.:</label><br/>
			<input class='inputCFornecedor' type='text' size='50' placeholder='00.000.000/0000-00' maxlength='18' onkeypress="formatar('##.###.###/####-##', this)" name='cnpj'/><br/>
			<button type="submit" id="botao" class="botao">Cadastrar</button>
			<a href="login.jsp"><div id="botao2" class="botao1">Logar</div></a>
		</form>
	</div>
	</section>
</body>
</html>