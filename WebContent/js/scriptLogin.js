$(document).ready(function() {
	$("#botao").on("click",function(){
		if(document.getElementById("usuario").value.length<=0 || document.getElementById("senha").value.length<=0){
			$("#campo1").hide();
			$("#campo2").hide();
			if(document.getElementById("usuario").value.length<=0){
				$("#campo1").show();
			}if(document.getElementById("senha").value.length<=0){
				$("#campo2").show();
			}
		}else{
			$("#formulario").submit();
		}
	});
	
	$(".input").keypress(function(e){
		if(e.wich==13 || e.keyCode==13){
			if(document.getElementById("usuario").value.length<=0 || document.getElementById("senha").value.length<=0){
				$("#campo1").hide();
				$("#campo2").hide();
				if(document.getElementById("usuario").value.length<=0){
					$("#campo1").show();
				}if(document.getElementById("senha").value.length<=0){
					$("#campo2").show();
				}
			}else{
				$("#formulario").submit();
			}
		}
	});
	
	$(".fechar").click(function(){
		$("#popupExt").fadeOut(400);
	});
});