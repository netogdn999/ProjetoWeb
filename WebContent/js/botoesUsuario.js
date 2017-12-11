$(document).ready(function() {	
	$(".excluir").click(function(e){
		var aux = $(this).attr('name');
		e.preventDefault();
		var link = $(".excluir a").attr('href');
		$.ajax({
			type: 'GET',
			url: link+"?login="+aux,
			success: function(data){
				$.ajax({
					type: 'GET',
					url: 'jsp/VisualizarUsuarios.jsp',
					success: function(data){
						alert("aaaaa");
						alert(data);
						$("#Formulario").html(data);
						$("#Formulario").show();
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