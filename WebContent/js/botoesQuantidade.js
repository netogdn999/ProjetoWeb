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
				$("#CF1").fadeIn(250);
				$("#CF6").fadeIn(250);
			},
			error: function(){
				alert("erro");
			}
		});
	});
});