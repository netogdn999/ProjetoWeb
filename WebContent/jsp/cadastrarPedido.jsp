<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.PedidoCompra"%>
<%@page import="control.UsuarioBean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="pedidoB" class="control.PedidoCompraBean" scope="page"></jsp:useBean>
<%
	try{
		PedidoCompra pedidoCompra=new PedidoCompra();
		UsuarioBean usuarioB=(UsuarioBean)session.getAttribute("usuarioB");
		java.util.Date data = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataFim")).getTime());
		java.sql.Date dataSQL = new java.sql.Date(data.getTime());
		pedidoB.setDataFim(dataSQL);
		if(dataSQL.after(new java.sql.Date(data.getTime()))){
			throw new Exception("Data invalida");
		}
		pedidoB.setLoginUsuario(usuarioB.getLogin());
		data = new java.util.Date();
		dataSQL = new java.sql.Date(data.getTime());
		pedidoB.setDataInicio(dataSQL);
		if(usuarioB.getPrivilegio()==1){
			pedidoB.setInterno(false);
		}else{
			pedidoB.setInterno(true);
		}
		pedidoCompra.inserir(pedidoB);
	}catch(Exception e){
		out.println("<h1>"+e.getMessage()+"</h1>");
	}
%>
<jsp:include page="produtos.jsp"/>
</body>
</html>