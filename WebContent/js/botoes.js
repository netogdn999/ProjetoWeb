$(document).ready(function() {
	$(".view").click(function(){
		var aux = $(this).attr('name');
		alert(aux);
	});
	
	$(".editar").click(function(e){
		var aux = $(this).attr('name');
		e.preventDefault();
		var link = $(".editar a").attr('href');
		$.ajax({
			type: 'GET',
			url: link+"?id="+aux,
			success: function(data){
				$("#SM1botao2").click();
				//$(".CadastrarFornecedor").fadeOut(-100);
				$("#CadastrarFornecedor").html(data);
			},
			error: function(){
				alert("erro");
			}
		});
	});
	
	$(".excluir").click(function(e){
		var aux = $(this).attr('name');
		e.preventDefault();
		var link = $(".excluir a").attr('href');
		$.ajax({
			type: 'GET',
			url: link+"?id="+aux,
			success: function(data){
				$.ajax({
					type: 'GET',
					url: 'jsp/visualizarFornecedor.jsp',
					success: function(data){
						$("#visualizarTabela").html(data);
						$("#visualizar").show();
					},
					error: function(){
					}
				});
			},
			error: function(){
			}
		});
	});
});