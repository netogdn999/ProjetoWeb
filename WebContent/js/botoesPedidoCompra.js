$(document).ready(function() {	
	$(".view").click(function(e){
		var link = $(".view a").attr('href');
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
				$("#CF2").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
	$(".excluir").click(function(e){
		var link = $(".excluir a").attr('href');
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
			}
		});
	});
});