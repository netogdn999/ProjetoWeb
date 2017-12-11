$(document).ready(function() {	
	$(".selecionar").click(function(e){
		var link = $(".selecionar a").attr('href');
		var aux = $(this).attr('name');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link+"?id="+aux,
			success: function(data){
				$("#Formulario").hide();
				$("#Formulario").html(data);
				$("#Formulario").show();
			},
			error: function(){
				alert("erro");
			}
		});
	});
});