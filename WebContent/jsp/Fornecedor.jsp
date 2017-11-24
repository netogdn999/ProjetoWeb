<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="model.Fornecedor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
<jsp:include page="../js/jquery-3.2.1.js"></jsp:include>
<jsp:include page="../js/menuScript.js"></jsp:include>
<jsp:include page="../js/scriptForm.js"></jsp:include>
</script>
<style type="text/css">
<jsp:include page="../css/FornecedorEstiloForm.css"></jsp:include>
<jsp:include page="../css/Alerta.css"></jsp:include>
</style>
<title>Insert title here</title>
</head>
<body>

<% 
	String op=request.getParameter("op");
	if(op.equals("1")){
		out.println("<form class='Formulario' name='cadastrar' method='post' action='jsp/cadastrarFornecedor.jsp' id='cadastrar'>"+
						"<div class='alerta' id='alerta'>"+
							"<figure class='fechar' id='fechar'>"+
								"<img src='imagens/fechar.png'>"+
							"</figure>"+
							"<p>"+
								"Cadastrado com sucesso!"+
							"</p>"+
						"</div>"+
						"<label for='nomeFantasia' class='labelCFornecedor' id='required'>Nome fantasia:</label>"+
						"<br/>"+
						"<input class='inputCFornecedor' type='text' required='required' placeholder='Nome fantasia da sua empresa' size='80' maxlength='80' name='nomeFantasia'/>"+
						"<br/>"+
						"<label for='razaoSocial' class='labelCFornecedor'>Razão social:</label>"+
						"<br/>"+
						"<input class='inputCFornecedor' type='text' required='required' placeholder='Razão social da sua empresa' size='80' maxlength='80' name='razaoSocial'/>"+
						"<br/>"+
						"<label for='endereco' class='labelCFornecedor1' id='required'>Endereco:</label>"+
						"<label for='endereco' class='labelCFornecedor' id='required'>Número:</label>"+
						"<br/>"+
						"<input class='inputCFornecedor1' type='text' required='required' placeholder='seu endereco com o prefixo(Av.,Rua,etc...)' size='60' maxlength='100' name='endereco''/>"+
						"<input class='inputCFornecedor' type='text' required='required' placeholder='Número' size='6' maxlength='6' name='numero'/>"+
						"<br/>"+
						"<label for='complemento' class='labelCFornecedor'>Complemento:</label>"+
						"<br/>"+
						"<input class='inputCFornecedor' type='text' placeholder='Complemento do seu endereco' size='80' maxlength='100' name='complemento'/>"+
						"<br/>"+
						"<label for='numero1' class='labelCFornecedorT' id='required'>Telefone1:</label>"+
						"<label for='numero2' class='labelCFornecedor'>Telefone2:</label>"+
						"<br/>"+
						"<input class='inputCFornecedorT' type='tel' required='required' size='15' maxlength='13' name='numero1' placeholder='99 99999-9999' onkeypress='formatar(\"## #####-####\", this)'/>"+
						"<input class='inputCFornecedor' type='tel' size='15' maxlength='13' name='numero2' placeholder='99 99999-9999' onkeypress='formatar(\"## #####-####\", this)'/>"+
						"<br/>"+
						"<label for='email' class='labelCFornecedor'>E-mail:</label>"+
						"<br/>"+
						"<input class='inputCFornecedor' type='text' placeholder='seuemail@gmail.com' size='80' maxlength='100' name='email'/>"+
						"<br/>"+
						"<label class='radio'>Pessoa física</label>"+
						"<input id='isFisica' class='radio1' type='radio' required='required' name='isPessoaF' checked='checked'>"+
						"<label class='radio'>Pessoa juridica</label>"+
						"<input id='isJuridica' class='radio' type='radio' required='required' name='isPessoaF'>"+
						"<br/>"+
						"<div id='pessoaFisica' class='pessoaFisica'>"+
							"<label for='cpf' class='labelCFornecedor' id='required'>C.P.F.:</label><br/>"+
							"<input class='inputCFornecedor' type='text' size='50' placeholder='000.000.000-00' maxlength='14' onkeypress='formatar(\"###.###.###-##\", this)' name='cpf'/>"+
						"</div>"+
						"<div id='pessoaJuridica' class='pessoaJuridica'>"+
							"<label for='cnpj' class='labelCFornecedor' id='required'>C.N.P.J.:</label><br/>"+
							"<input class='inputCFornecedor' type='text' size='50' placeholder='00.000.000/0000-00' maxlength='18' onkeypress='formatar(\"##.###.###/####-##\", this)' name='cnpj'/><br/>"+
							"<label for='inscricaoEStadual' class='labelCFornecedor'>Inscricao estadual:</label><br/>"+
							"<input class='inputCFornecedor' type='text' placeholder='000.000.000.000'size='50' maxlength='12' name='inscricaoEStadual'/>"+
						"</div>"+
					"</form>");  
	}else if(op.equals("2")){
		out.println("<form class='Formulario' name='cadastrar' method='post' action='jsp/cadastrarFornecedor.jsp' id='cadastrar'>"+
				"<div class='alerta' id='alerta'>"+
					"<figure class='fechar' id='fechar'>"+
						"<img src='imagens/fechar.png'>"+
					"</figure>"+
					"<p>"+
						"Cadastrado com sucesso!"+
					"</p>"+
				"</div>"+
				"<label for='nomeFantasia' class='labelCFornecedor' id='required'>Nome fantasia:</label>"+
				"<br/>"+
				"<input class='inputCFornecedor' type='text' required='required' placeholder='Nome fantasia da sua empresa' size='80' maxlength='80' name='nomeFantasia' readonly='true'/>"+
				"<br/>"+
				"<label for='razaoSocial' class='labelCFornecedor'>Razão social:</label>"+
				"<br/>"+
				"<input class='inputCFornecedor' type='text' required='required' placeholder='Razão social da sua empresa' size='80' maxlength='80' name='razaoSocial' readonly='true'/>"+
				"<br/>"+
				"<label for='endereco' class='labelCFornecedor1' id='required'>Endereco:</label>"+
				"<label for='endereco' class='labelCFornecedor' id='required'>Número:</label>"+
				"<br/>"+
				"<input class='inputCFornecedor1' type='text' required='required' placeholder='seu endereco com o prefixo(Av.,Rua,etc...)' size='60' maxlength='100' name='endereco' readonly='true'/>"+
				"<input class='inputCFornecedor' type='text' required='required' placeholder='Número' size='6' maxlength='6' name='numero' readonly='true'/>"+
				"<br/>"+
				"<label for='complemento' class='labelCFornecedor'>Complemento:</label>"+
				"<br/>"+
				"<input class='inputCFornecedor' type='text' placeholder='Complemento do seu endereco' size='80' maxlength='100' name='complemento' readonly='true'/>"+
				"<br/>"+
				"<label for='numero1' class='labelCFornecedorT' id='required'>Telefone1:</label>"+
				"<label for='numero2' class='labelCFornecedor'>Telefone2:</label>"+
				"<br/>"+
				"<input class='inputCFornecedorT' type='tel' required='required' size='15' maxlength='13' name='numero1' placeholder='99 99999-9999' onkeypress='formatar(\"## #####-####\", this)' readonly='true'/>"+
				"<input class='inputCFornecedor' type='tel' size='15' maxlength='13' name='numero2' placeholder='99 99999-9999' onkeypress='formatar(\"## #####-####\", this)' readonly='true'/>"+
				"<br/>"+
				"<label for='email' class='labelCFornecedor'>E-mail:</label>"+
				"<br/>"+
				"<input class='inputCFornecedor' type='text' placeholder='seuemail@gmail.com' size='80' maxlength='100' name='email' readonly='true'/>"+
				"<br/>"+
				"<label class='radio'>Pessoa física</label>"+
				"<input id='isFisica' class='radio1' type='radio' required='required' name='isPessoaF' checked='checked' readonly='true'>"+
				"<label class='radio'>Pessoa juridica</label>"+
				"<input id='isJuridica' class='radio' type='radio' required='required' name='isPessoaF' readonly='true'>"+
				"<br/>"+
				"<div id='pessoaFisica' class='pessoaFisica'>"+
					"<label for='cpf' class='labelCFornecedor' id='required'>C.P.F.:</label><br/>"+
					"<input class='inputCFornecedor' type='text' size='50' placeholder='000.000.000-00' maxlength='14' onkeypress='formatar(\"###.###.###-##\", this)' name='cpf' readonly='true'/>"+
				"</div>"+
				"<div id='pessoaJuridica' class='pessoaJuridica'>"+
					"<label for='cnpj' class='labelCFornecedor' id='required'>C.N.P.J.:</label><br/>"+
					"<input class='inputCFornecedor' type='text' size='50' placeholder='00.000.000/0000-00' maxlength='18' onkeypress='formatar(\"##.###.###/####-##\", this)' name='cnpj' readonly='true'/><br/>"+
					"<label for='inscricaoEStadual' class='labelCFornecedor'>Inscricao estadual:</label><br/>"+
					"<input class='inputCFornecedor' type='text' placeholder='000.000.000.000'size='50' maxlength='12' name='inscricaoEStadual' readonly='true'/>"+
				"</div>"+
			"</form>"); 
	}
%>
</body>
</html>