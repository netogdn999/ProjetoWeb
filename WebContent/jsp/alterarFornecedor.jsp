<%@page import="java.util.ArrayList"%>
<%@page import="model.Fornecedor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>alterar fornecedor</title>
</head>
<body>
<%	
	Fornecedor fornecedor=new Fornecedor();
	ArrayList<Fornecedor> fornecedores=fornecedor.buscarFornecedor(request.getParameter("id"));
	fornecedor=fornecedores.get(0);
	out.println("<html>"+
					"<script rel=\"text/script\" src=\"js/jquery-3.2.1.js\" charset=\"UTF-8\"></script>"+
					"<script rel=\"text/script\" src=\"js/botoes.js\" charset=\"UTF-8\"></script>"+
					"<body>"+
							"<div class=\"alerta\" id=\"alerta2\">"+
								"<figure class=\"fechar\" id=\"fechar2\">"+
									"<img src=\"imagens/fechar.png\">"+
								"</figure>"+
								"<p>"+
									"Alterado com sucesso!"+
								"</p>"+
							"</div>"+
							"<label for=\"nome\" class=\"labelCFornecedor\" id=\"required\">Nome:</label>"+
							"<br/>"+
							"<input class=\"inputCFornecedor\" type=\"text\" required=\"required\" size=\"80\" maxlength=\"80\" name=\"nome\" value=\""+fornecedor.getNome()+"\"/>"+
							"<br/>"+
							"<label for=\"endereco\" class=\"labelCFornecedor1\" id=\"required\">Endereco:</label>"+
							"<label for=\"endereco\" class=\"labelCFornecedor\" id=\"required\">Número:</label>"+
							"<br/>"+
							"<input class=\"inputCFornecedor1\" type=\"text\" required=\"required\" size=\"60\" maxlength=\"100\" name=\"endereco\" value=\""+fornecedor.getEndereco().getEndereco()+"\"/>"+
							"<input class=\"inputCFornecedor\" type=\"text\" required=\"required\" size=\"6\" maxlength=\"6\" name=\"numero\" value=\""+fornecedor.getEndereco().getNumero()+"\"/>"+
							"<br/>"+
							"<label for=\"complemento\" class=\"labelCFornecedor\">Complemento:</label>"+
							"<br/>"+
							"<input class=\"inputCFornecedor\" type=\"text\" size=\"80\" maxlength=\"100\" name=\"complemento\" value=\""+fornecedor.getEndereco().getComplemento()+"\"/>"+
							"<br/>"+
							"<label for=\"numero1\" class=\"labelCFornecedorT\" id=\"required\">Telefone1:</label>"+
							"<label for=\"numero2\" class=\"labelCFornecedor\">Telefone2:</label>"+
							"<br/>"+
							"<input class=\"inputCFornecedorT\" type=\"tel\" required=\"required\" size=\"15\" maxlength=\"13\" name=\"numero1\" placeholder=\"99 99999-9999\" onkeypress=\"formatar('## #####-####', this)\" value=\""+fornecedor.getContato().getNumero1()+"\"/>"+
							"<input class=\"inputCFornecedor\" type=\"tel\" size=\"15\" maxlength=\"13\" name=\"numero2\" placeholder=\"99 99999-9999\" onkeypress=\"formatar('## #####-####', this)\" value=\""+fornecedor.getContato().getNumero2()+"\"/>"+
							"<br/>"+
							"<label for=\"email\" class=\"labelCFornecedor\">E-mail:</label>"+
							"<br/>"+
							"<input class=\"inputCFornecedor\" type=\"text\" size=\"80\" maxlength=\"100\" name=\"email\" value=\""+fornecedor.getContato().getEmail()+"\"/>"+
							"<br/>"+
							"<label class=\"radio\">Pessoa física</label>");
			if(fornecedor.isPessoaF()){
				out.println("<input id=\"isFisica2\" class=\"radio1\" type=\"radio\" required=\"required\" name=\"isPessoaF\" checked=\"checked\">"+
							"<label class=\"radio\">Pessoa juridica</label>"+
							"<input id=\"isJuridica2\" class=\"radio\" type=\"radio\" required=\"required\" name=\"isPessoaF\">"+
							"<br/>"+
							"<div id=\"pessoaFisica2\" class=\"pessoaFisica\">"+
								"<label for=\"cpf\" class=\"labelCFornecedor\" id=\"required\">C.P.F.:</label><br/>"+
								"<input class=\"inputCFornecedor\" type=\"text\" size=\"50\" maxlength=\"14\" onkeypress=\"formatar('###.###.###-##', this)\" name=\"cpf\" value=\""+fornecedor.getCpf()+"\"/>"+
							"</div>"+
							"<div id=\"pessoaJuridica2\" class=\"pessoaJuridica\">"+
								"<label for=\"cnpj\" class=\"labelCFornecedor\" id=\"required\">C.N.P.J.:</label><br/>"+
								"<input class=\"inputCFornecedor\" type=\"text\" size=\"50\" maxlength=\"18\" onkeypress=\"formatar('##.###.###/####-##', this)\" name=\"cnpj\" value=\""+fornecedor.getCnpj()+"\"/>"+
							"</div>");
			}else{
				out.println("<input id=\"isFisica2\" class=\"radio1\" type=\"radio\" required=\"required\" name=\"isPessoaF\">"+
							"<label class=\"radio\">Pessoa juridica</label>"+
							"<input id=\"isJuridica2\" class=\"radio\" type=\"radio\" required=\"required\" name=\"isPessoaF\" checked=\"checked\">"+
							"<br/>"+
							"<div id=\"pessoaFisica2\" class=\"pessoaFisica\">"+
								"<label for=\"cpf\" class=\"labelCFornecedor\" id=\"required\">C.P.F.:</label><br/>"+
								"<input class=\"inputCFornecedor\" type=\"text\" size=\"50\" maxlength=\"14\" onkeypress=\"formatar('###.###.###-##', this)\" name=\"cpf\" value=\""+fornecedor.getCpf()+"\"/>"+
							"</div>"+
							"<div id=\"pessoaJuridica2\" class=\"pessoaJuridica\">"+
								"<label for=\"cnpj\" class=\"labelCFornecedor\" id=\"required\">C.N.P.J.:</label><br/>"+
								"<input class=\"inputCFornecedor\" type=\"text\" size=\"50\" maxlength=\"18\" onkeypress=\"formatar('##.###.###/####-##', this)\" name=\"cnpj\" value=\""+fornecedor.getCnpj()+"\"/>"+
							"</div>");
			}
			out.println("</body>"+
			"</html>");
%>
</body>
</html>