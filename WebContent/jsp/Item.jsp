<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<jsp:include page="../css/ItemEstilo.css"></jsp:include>
</style>
<title>Insert title here</title>
</head>
<body>
<%
for(int i=0; i<Integer.parseInt(request.getParameter("qtd"));i++){
out.println("<label for='nome' class='labelCItem' id='required'>Nome:</label>"+
		    "<label for='marca' class='labelCItem' id='required'>Marca:</label>"+
		    "<label for='categoria' class='labelCItem' id='required'>Categoria:</label>"+
		    "<label for='qtd' class='labelCItem2' id='required'>Quantidade:</label>"+
			"<br/>"+
			"<input class='inputCItem' type='text' required='required' placeholder='Nome do produto' size='20' maxlength='20' name='nome"+i+"'/>"+
			"<input class='inputCItem' type='text' required='required' placeholder='Marca do produto' size='20' maxlength='20' name='marca"+i+"'/>"+
			"<input class='inputCItem' type='text' required='required' placeholder='Senha do usuário' size='20' maxlength='20' name='categoria"+i+"'/>"+
			"<input class='inputCItem' type='number' required='required' placeholder='Quantidade do produto' size='20' maxlength='20' name='qtd"+i+"'/>"+
			"<br/>"
			);  
}
%>
</body>
</html>