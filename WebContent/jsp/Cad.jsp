<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="control.UsuarioB"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script rel="text/script" src="js/jquery-3.2.1.js" charset="UTF-8"></script>
<title>Insert title here</title>
</head>
<body>
<%
		out.println("<script>alert(\"aaaaaa\")</script>");
	try{
		UsuarioB userB=new UsuarioB();
		userB.setNome(request.getParameter("nome"));
		userB.setLogin(request.getParameter("usuario"));
		userB.setSenha(request.getParameter("senha"));
		userB.setSetor(Integer.parseInt(request.getParameter("nivel")));
		if(request.getParameter("isPessoaFisica").equals("true")){
			userB.setCpf(request.getParameter("cpf"));
		}else{
			userB.setCnpj(request.getParameter("cnpj"));
		}
	}catch(Exception e){
		out.println("<html><head><script rel=\"text/script\" src=js\"jquery-3.2.1.js\"></script></head><body><script>$(\"#popupExt\").fadeIn(400);</script></body></html>");
	}
%>
</body>
</html>