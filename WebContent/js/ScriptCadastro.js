$(document).ready(function() {
	$("#botao").click(function(e){
		e.preventDefault();
		$("#formulario").ajaxSubmit({
			success: function(form) {
				alert("entrou");
			}
		});
	});
});