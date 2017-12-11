<%@page import="java.util.ArrayList"%>
<%@page import="control.FornecedorBean"%>
<%@page import="control.UsuarioBean"%>
<%@page import="model.Fornecedor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Tabelas.css" />
<script type="text/javascript">
<jsp:include page="../js/jquery-3.2.1.js"></jsp:include>
<jsp:include page="../js/botoesFornecedores.js"></jsp:include>
</script>
<title>Insert title here</title>
</head>
<body>
<% 
	Fornecedor fornecedor=new Fornecedor();
	FornecedorBean fornecedorB=new FornecedorBean();
	ArrayList<FornecedorBean> fornecedores=fornecedor.mostrarTodas();
	out.println("<table class=\"visualizarFornecedor2\">"+
							"<tr>"+
								"<td>Nome fantasia</td>"+
								"<td>Razao social</td>"+
								"<td>CNPJ</td>"+
								"<td>E-mail</td>"+
								"<td>Endereco</td>"+
								"<td>CEP</td>"+
								"<td>Telefone 1</td>"+
								"<td>Telefone 2</td>"+
								"<td>Autenticar</td>"+
								"<td>Excluir</td>"+
							"</tr>");
							for(int i=0; i<fornecedores.size();i++){
								fornecedorB=fornecedores.get(i);
								if(!fornecedorB.isAutenticado()){
					out.println("<tr class=\"dados\">"+
									"<td>"+fornecedorB.getNomeFantasia()+"</td>"+
									"<td>"+fornecedorB.getRazaoSocial()+"</td>"+
									"<td>"+fornecedorB.getCnpj()+"</td>"+
									"<td>"+fornecedorB.getEmail()+"</td>"+
									"<td>"+fornecedorB.getEndereco()+"</td>"+
									"<td>"+fornecedorB.getCep()+"</td>"+
									"<td>"+fornecedorB.getTelefone1()+"</td>"+
									"<td>"+fornecedorB.getTelefone2()+"</td>"+
									"<td><button class='autenticar' name='"+fornecedorB.getId()+"'><a href='jsp/autenticarFornecedor.jsp'><img src='imagens/editar.png'></a></button></td>"+
									"<td><button class='excluir' name='"+fornecedorB.getId()+"'><a href='jsp/excluirFornecedor.jsp'><img src='imagens/excluir.png'></a></button></td>"+
								"</tr>");
								}
							}
			out.println("</table>"); 
%>
</body>
</html>