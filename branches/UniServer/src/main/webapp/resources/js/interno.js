
abrirConteudo = function(url){
	
	$.ajax({
		url: url,
		success: function(data){
			$("#content").html("");
			$("#content").html(data);
		},
		error: function(erro){
			alert(erro.responseText);
			location.reload();
		}
	});
}


salvarCurso = function(){
	var nmCursoTxt = $("#nmCurso").val();
	
	$.ajax({
		url: "/UniServer/admin/curso.do?acao=salvarCurso",
		dataType: "json",
		data: {
			nome: nmCursoTxt
		},
		success: function(data){
			alert(data);
			$('form').trigger("reset");
		},
		error: function(erro){
			alert(erro.responseText);
		}
	});
}

salvarProfessor = function(){
	var form = $("form").serialize();
	
	if($("input[name='senha']").val() != $("input[name='senhaConfirm']").val()){
		alert("Senhas não conferem");
		return;
	}
	$.ajax({
		url: "/UniServer/admin/professor.do?acao=salvarProfessor",
		data: form,
		success: function(data){
			alert(data);
			$('form').trigger("reset");
		},
		error: function(erro){
			alert(erro.responseText);
		}
	});
}


salvarDisciplina = function(){
	var form = $("form").serialize();
	
	$.ajax({
		url: "/UniServer/admin/disciplina.do?acao=salvarDisciplina",
		data: form,
		success: function(data){
			alert(data);
			$('form').trigger("reset");
		},
		error: function(erro){
			alert(erro.responseText);
		}
	});
}

salvarTurma = function(){
	var form = $("form").serialize();
	
	$.ajax({
		url: "/UniServer/admin/turma.do?acao=salvarTurma",
		data: form,
		success: function(data){
			alert(data);
			$('form').trigger("reset");
			$('#disciplinas').html("");
			$("#disciplinas").css('visibility', 'hidden');
		},
		error: function(erro){
			alert(erro.responseText);
		}
	});
}

updateDisciplinas = function(){
	var curso = $("#curso").val();
	
	if(curso <=0){
		$('#disciplinas').html("");
		$("#disciplinas").css('visibility', 'hidden');
		return;
	}
	
	$.ajax({
		url: "/UniServer/admin/turma.do?acao=carregarDisciplinasCurso",
		dataType: "json",
		data: {
			idCurso: curso
		},
		success: function(data){
			if(data.length > 0){
				$('#disciplinas').html("");
				
				for(i = 0; i<data.length; i++){
					var item = $("<option>").val(data[i].id).html(data[i].nome);
					$("#disciplinas").append(item);
				}
				
				$("#disciplinas").css('visibility', 'visible');
			}else{
				alert("Não foi encontrada Disciplinas para o curso escolhido");
			}
		},
		error: function(erro){
			alert(erro.responseText);
		}
	});
}


/*
AjaxRequest = function(sucessMethod, errorMethod, url, params){
	this.url = url;
	this.sucessMethod = sucessMethod;
	this.errorMethod = errorMethod;
	this.params = params;
	
	this.request = function(this.url, this.sucessMethod, this.errorMethod, this.params){
		$.ajax({
			url: this.url,
			success: this.sucessMethod.call(data),
			error: this.errorMethod.call(erro)
		});
	}
}
*/