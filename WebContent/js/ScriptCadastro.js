$(document).ready(function() {
	$("#botao a").click(function(){
		$("#formulario").ajaxSubmit({
			success: function(form) {
				alert("entrou");
			}
		});
	});
});