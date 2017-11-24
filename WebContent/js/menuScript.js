$(document).ready(function() {
	menu=function(menuS,menuH1,menuH2,menuH3,menuH4) {
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$("#reset").click();
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM1botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$(menuH1).hide();
		$(menuH2).hide();
		$(menuH3).hide();
		$(menuH4).hide();
		$(menuS).show();
	}
	
	sair=function(){
		$("#sair").fadeIn(450);
	}
	
	$("#SM1botao1").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM1botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'yellow'});
//		e.preventDefault();
//		var link=$("#SM1botao1 a").attr('href');
//		$.ajax({
//			type: 'GET',
//			url: link,
//			success: function(data){
//				$("#visualizarTabela").html(data);
//				$("#visualizar").show();
//			},
//			error: function(){
//			}
//		});
	});
	
	$("#SM1botao2").click(function(e) {
		e.preventDefault();
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM1botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM1botao2 a").css({'color':'yellow'});
		var link=$("#SM1botao2 a").attr('href');
		$.ajax({
			type: 'GET',
			url: link+"?op=1",
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
				$("#CF1").fadeIn(250);
				$("#CF2").fadeIn(250);
				$("#CF3").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
	$("#SM2botao1").click(function() {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM2botao1").css({'color':'yellow'});
	});
	
	$("#SM2botao2").click(function() {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM2botao2").css({'color':'yellow'});
	});
	
	$("#SM2botao3").click(function(e) {
		e.preventDefault();
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM2botao3").css({'color':'yellow'});
		var link=$("#SM2botao3 a").attr('href');
		$.ajax({
			type: 'GET',
			url: link+"?op=1",
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
				$("#CF1").fadeIn(250);
				$("#CF2").fadeIn(250);
				$("#CF3").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
	$("#SM3botao1").click(function() {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM3botao1").css({'color':'yellow'});
	});
	
	$("#SM3botao2").click(function() {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM3botao2").css({'color':'yellow'});
	});
	
	$("#SM3botao3").click(function() {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM3botao3").css({'color':'yellow'});
	});
	
	$("#SM4botao1").click(function() {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM4botao1").css({'color':'yellow'});
	});
	
	$("#SM4botao2").click(function() {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM4botao2").css({'color':'yellow'});
	});
	
	$("#SM4botao3").click(function() {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM4botao3").css({'color':'yellow'});
	});
	
	$("#CF3").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM1botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'yellow'});
//		e.preventDefault();
//		var link=$("#CF3 a").attr('href');
//		$.ajax({
//			type: 'GET',
//			url: link,
//			success: function(data){
//				$("#visualizarTabela").html(data);
//				$("#visualizar").show();
//			},
//			error: function(){
//			}
//		});
	});
	
	$("#CF2").click(function(e) {
//		//if(this.checkValidity()){
//			e.preventDefault();
//			$("#cadastrar").ajaxSubmit({
//				success: function(form) {
//					$("#reset").click();
//					$("#alerta").fadeOut(500);
//					$("#alerta").fadeIn(500);
//				}
//			});
//		//}
	});
	
	$("#CF1").click(function() {
		$('#window').fadeIn(250);
	});
	
	exit=function(nome){
		$(nome).fadeOut(250);
	};
	
	$("#reset").click(function() {
		$('#window').fadeOut(250);
	});
	
	$("#fechar").click(function() {
		$("#alerta").fadeOut(500);
	});
});