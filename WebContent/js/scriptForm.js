$(document).ready(function() {
	formatar=function (mascara, documento) {
		var i = documento.value.length;
		var saida = mascara.substring(0, 1);
		var texto = mascara.substring(i)

		if (texto.substring(0, 1) != saida) {
			documento.value += texto.substring(0, 1);
		}
	}
	
	$("#isFisica").click(function() {
		$("#pessoaJuridica").fadeOut(-100);
		$("#pessoaFisica").fadeIn(250);
	});
	
	$("#isJuridica").click(function() {
		$("#pessoaFisica").fadeOut(-100);
		$("#pessoaJuridica").fadeIn(250);
	});
	
	$("#isFisica2").click(function() {
		$("#pessoaJuridica2").fadeOut(-100);
		$("#pessoaFisica2").fadeIn(250);
	});
	
	$("#isJuridica2").click(function() {
		$("#pessoaFisica2").fadeOut(-100);
		$("#pessoaJuridica2").fadeIn(250);
	});
});