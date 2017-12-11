<%@page import="java.util.ArrayList"%>
<%@page import="control.UsuarioBean"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<jsp:include page="../css/TabelaUsuario.css"></jsp:include>
</style>
<script type="text/javascript">
<jsp:include page="../js/jquery-3.2.1.js"></jsp:include>
<jsp:include page="../js/botoesUsuario.js"></jsp:include>
</script>
<title>Insert title here</title>
</head>
<body>
<% 
	UsuarioBean usuarioB=(UsuarioBean)session.getAttribute("usuarioB");
	System.out.println(usuarioB.getPrivilegio());
	if(usuarioB.getPrivilegio()==1){
		Usuario usuario=new Usuario();
		UsuarioBean usuarioBean=new UsuarioBean();
		ArrayList<UsuarioBean> usuarios=usuario.mostrarTodas();
		out.println("<table class='visualizarusuario2'>"+
								"<tr>"+
									"<td>Nome</td>"+
									"<td>Setor</td>"+
									"<td>Excluir</td>"+
								"</tr>");
								for(int i=0; i<usuarios.size();i++){
									usuarioBean=usuarios.get(i);
									if(usuarioBean.getPrivilegio()==1){
										continue;
									}
						out.println("<tr class='dados'>"+
										"<td>"+usuarioBean.getNome()+"</td>"+
										"<td>"+usuarioBean.getSetor()+"</td>"+
										"<td><button class='excluir' name='"+usuarioBean.getLogin()+"'><a href='jsp/ExcluirUsuario.jsp'><img src='imagens/excluir.png'></a></button></td>"+
									"</tr>");
								}
				out.println("</table>"); 
	}else if(usuarioB.getPrivilegio()==2){
		Usuario usuario=new Usuario();
		UsuarioBean usuarioBean=new UsuarioBean();
		ArrayList<UsuarioBean> usuarios=usuario.mostrarTodas();
		out.println("<table class=\"visualizarusuario2\">"+
								"<tr>"+
									"<td>Nome</td>"+
									"<td>Setor</td>"+
									"<td>Excluir</td>"+
								"</tr>");
								for(int i=0; i<usuarios.size();i++){
									usuarioBean=usuarios.get(i);
									if(usuarioBean.getPrivilegio()==2 || usuarioBean.getPrivilegio()==1){
										continue;
									}
						out.println("<tr class=\"dados\">"+
										"<td>"+usuarioBean.getNome()+"</td>"+
										"<td>"+usuarioBean.getSetor()+"</td>"+
										"<td><button class='excluir' name='"+usuarioBean.getLogin()+"'><a href='jsp/ExcluirUsuario.jsp'><img src='imagens/excluir.png'></a></button></td>"+
									"</tr>");
								}
				out.println("</table>"); 
		
	}
%>
</body>
</html>