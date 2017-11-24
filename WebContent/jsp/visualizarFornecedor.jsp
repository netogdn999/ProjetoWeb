<%@page import="java.util.ArrayList"%>
<%@page import="model.Fornecedor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	Fornecedor fornecedor=new Fornecedor();
	ArrayList<Fornecedor> fornecedores=fornecedor.buscarFornecedor();
	out.println("<html>"+
					"<head>"+
						"<script rel=\"text/script\" src=\"js/jquery-3.2.1.js\" charset=\"UTF-8\"></script>"+
						"<script rel=\"text/script\" src=\"js/botoes.js\" charset=\"UTF-8\"></script>"+
					"</head>"+
					"<body>"+
						"<table class=\"visualizarFornecedor2\">"+
							"<tr>"+
								"<td>Nome</td>"+
								"<td>C.P.F.</td>"+
								"<td>Telefone1</td>"+
								"<td>Telefone2</td>"+
								"<td>E-mail</td>"+
								"<td>Visualizar</td>"+
								"<td>Alterar</td>"+
								"<td>Excluir</td>"+
							"</tr>");
							for(int i=0; i<fornecedores.size();i++){
								fornecedor=fornecedores.get(i);
					out.println("<tr class=\"dados\">"+
									"<td>"+fornecedor.getNome()+"</td>"+
									"<td>"+fornecedor.getCpf()+"</td>"+
									"<td>"+fornecedor.getContato().getNumero1()+"</td>"+
									"<td>"+fornecedor.getContato().getNumero2()+"</td>"+
									"<td>"+fornecedor.getContato().getEmail()+"</td>"+
									"<td><button class=\"view\" name=\""+fornecedor.getId()+"\"><a href=\"jsp/excluirFornecedor.jsp\"><img src=\"imagens/view.png\"></a></button></td>"+
									"<td><button class=\"editar\" name=\""+fornecedor.getId()+"\"><a href=\"jsp/alterarFornecedor.jsp\"><img src=\"imagens/editar.png\"></a></button></td>"+
									"<td><button class=\"excluir\" name=\""+fornecedor.getId()+"\"><a href=\"jsp/excluirFornecedor.jsp\"><img src=\"imagens/excluir.png\"></a></button></td>"+
								"</tr>");
							}
			out.println("</table>"+
					"</body>"+
				"</html>"); 
%>
</body>
</html>