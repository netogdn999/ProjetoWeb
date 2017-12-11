$(document).ready(function() {
	$(".view").click(function(){
		var aux = $(this).attr('name');
		alert(aux);
	});
	
	$(".autenticar").click(function(e){
		var link = $(".autenticar a").attr('href');
		var aux = $(this).attr('name');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link+"?id="+aux,
			success: function(data){
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