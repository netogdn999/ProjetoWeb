$(document).ready(function() {
	menu=function(menuS,menuH1,menuH2,menuH3,menuH4) {
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$("#reset").click();
		$(".botao").css({'color':'white'});
		$("#SM2botao1 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM4botao1 a").css({'color':'white'});
		$("#SM4botao2 a").css({'color':'white'});
		$(menuH1).hide();
		$(menuH2).hide();
		$(menuH3).hide();
		$(menuH4).hide();
		$(menuS).show();
	}
	
	sair=function(){
		$("#sair").fadeIn(450);
	}
	
	$("#subMenu3").click(function(e) {
		alert("aqui");
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: "jsp/ListarPedidoLance.jsp",
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
			},
			error: function(){
			}
		});
	})
	
	$("#SM1botao1").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM1botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'yellow'});
		var link=$("#SM1botao1 a").attr('href');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link,
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
	$("#SM1botao2").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM1botao2 a").css({'color':'white'});
		$("#SM1botao2 a").css({'color':'yellow'});
		var link=$("#SM1botao2 a").attr('href');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link,
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
//	$("#SM1botao2").click(function(e) {
//		e.preventDefault();
//		$("#reset").click();
//		$("article").fadeOut(-100);
//		$(".button").fadeOut(-100);
//		$(".botao").css({'color':'white'});
//		$("#SM2botao3 a").css({'color':'white'});
//		$("#SM1botao2 a").css({'color':'white'});
//		$("#SM1botao1 a").css({'color':'white'});
//		$("#SM1botao2 a").css({'color':'yellow'});
//		var link=$("#SM1botao2 a").attr('href');
//		$.ajax({
//			type: 'GET',
//			url: link+"?op=1",
//			success: function(data){
//				$("#Formulario").html(data);
//				$("#Formulario").fadeIn(250);
//				$("#CF1").fadeIn(250);
//				$("#CF2").fadeIn(250);
//				$("#CF3").fadeIn(250);
//			},
//			error: function(){
//			}
//		});
//	});
	
	$("#SM2botao1").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM2botao1 a").css({'color':'yellow'});
		var link=$("#SM2botao1 a").attr('href');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link,
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
	$("#SM2botao2").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM2botao1 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'yellow'});
		var link=$("#SM2botao2 a").attr('href');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link+"?op=1",
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
				$("#CF1").fadeIn(250);
				$("#CF2").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
	$("#SM4botao1").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM4botao2 a").css({'color':'white'});
		$("#SM4botao3 a").css({'color':'white'});
		$("#SM4botao4 a").css({'color':'white'});
		$("#SM4botao1 a").css({'color':'yellow'});
		var link=$("#SM4botao1 a").attr('href');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link,
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
				$("#CF1").fadeIn(250);
				$("#CF5").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
	$("#SM4botao2").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM4botao1 a").css({'color':'white'});
		$("#SM4botao2 a").css({'color':'yellow'});
		$("#SM4botao3 a").css({'color':'white'});
		$("#SM4botao4 a").css({'color':'white'});
		var link=$("#SM4botao2 a").attr('href');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link,
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	
	$("#SM4botao3").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM4botao1 a").css({'color':'white'});
		$("#SM4botao2 a").css({'color':'white'});
		$("#SM4botao4 a").css({'color':'white'});
		$("#SM4botao3 a").css({'color':'yellow'});
		var link=$("#SM4botao3 a").attr('href');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link,
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
				$("#CF1").fadeIn(250);
				$("#CF2").fadeIn(250);
			},
			error: function(){
			}
		});
	});
	$("#SM4botao4").click(function(e) {
		$("#reset").click();
		$("article").fadeOut(-100);
		$(".button").fadeOut(-100);
		$(".botao").css({'color':'white'});
		$("#SM2botao3 a").css({'color':'white'});
		$("#SM2botao2 a").css({'color':'white'});
		$("#SM1botao1 a").css({'color':'white'});
		$("#SM4botao1 a").css({'color':'white'});
		$("#SM4botao2 a").css({'color':'white'});
		$("#SM4botao3 a").css({'color':'white'});
		$("#SM4botao4 a").css({'color':'yellow'});
		var link=$("#SM4botao4 a").attr('href');
		e.preventDefault();
		$.ajax({
			type: 'GET',
			url: link,
			success: function(data){
				$("#Formulario").html(data);
				$("#Formulario").fadeIn(250);
			},
			error: function(){
			}
		});
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
		//e.preventDefault();
	});
	
	$("#CF5").click(function(e) {
		e.preventDefault();
		$(".Formulario").ajaxSubmit({
			success: function(data) {
				$("#Formulario").html(data);
				$("#Formulario").show();
				$(".button").fadeOut(-100);
			},
			error: function() {
				alert("error");
			}
		});
	});
	
	$("#CF6").click(function(e) {
		e.preventDefault();
		$.ajax({
            url: $(".Formulario").attr('action'),
            type: 'POST',
            data: $(".Formulario").serialize(),
            success: function(data) {
				$("#Formulario").html(data);
				$("#Formulario").show();
				$(".button").fadeOut(-100);
            }
        });
	});
	
	$("#CF4").click(function(e) {
		e.preventDefault();
		var link=$("#CF4 a").attr('href');
		var qtd=$("#qtd").val();
		if(qtd==""){
			qtd=0;
		}
		$.ajax({
			type: 'GET',
			url: link+"?qtd="+qtd,
			success: function(data){
				$("#itens").html(data);
			},
			error: function(){
			}
		});
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