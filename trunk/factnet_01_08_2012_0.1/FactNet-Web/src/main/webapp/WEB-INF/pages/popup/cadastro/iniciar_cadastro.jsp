<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Clientes - WEB</title>
<link rel="stylesheet" media="screen" href="css/style_fact_com.css" type="text/css">   
<script type="text/javascript" src="javascript/jquery-1.8.1.min.js"></script>
<style>
	body{
		background:#EEE;
		font:Arial, Helvetica, sans-serif;
			
	}
</style>
<!--
jQuery(function($){
	$().mask();
});
-->
<script type="text/javascript">

function cadastrar(){
	$(document).ready(function(){
		var dataForm = $("#cadastro").serialize()+"&meioInclusao=3";
		jQuery.ajax({
			type: "POST",
			url: "cadastro.do?acao=cadastrar",
			datatype: "html",
			data: dataForm,
			success: function(data, textStatus, jqXHR){
				alert(data);
				window.parent.Shadowbox.close();
			},
			error: function(request, status, error){
				alert(request.responseText);
				window.parent.Shadowbox.close();
			}
		});
	});
	
}
</script>
</head>
<body>
	<label id="titulo">Cadastro de Cliente</label>
	<form action="cadastro.do?acao=cadastrar"  id="cadastro">
		<fieldset>
			<legend>Pessoal</legend>
			<div>
				<label class="campo_obrigatorio">Nome: </label> <input type="text" maxlength="50" name="nome" title="Nome" placeholder="Fulado"/><br>
				<label class="campo_obrigatorio">Sobrenome: </label> <input type="text" maxlength="100" name="sobrenome" title="Sobrenome" placeholder="de Tal"/><br>
				<label class="campo_obrigatorio">Sexo: </label> 
									<input type="radio" name="sexo" value="F"/>Feminino  
				   				    <input type="radio" name="sexo" value="M"/>Masculino
		        <br>
				<label class="campo_obrigatorio">Data Nascimento: </label> 
						<input type="date" name="dataNascimento" title="Data Nascimento" placeholder="dd/mm/aaaa"/>
				<br>
			</div>
		</fieldset>
		
		<fieldset>
			<legend>Contato</legend>
			<div>
				<label class="campo_opcional">Telefone: </label> <input type="tel" name="nuTelefone" maxlength="15" title="Telefone" placeholder="(xx) 1234-5678"/><br>
				<label class="campo_obrigatorio">Pais: </label> <input type="text" name="pais" maxlength="50" title="Pais" placeholder="Pais"/><br>
				<label class="campo_obrigatorio">Cidade/Estado: </label> 
						<input type="text" name="cidade" maxlength="50" title="Cidade/Estado" placeholder = "Exemplo - EX"/>
				</label><br>
				<label class="campo_obrigatorio">CEP: </label> <input type="text" name="endereco" maxlength="100" title="Endereço" placeholder="Av. Exemplo"/><br>
				<label class="campo_obrigatorio">CEP: </label> <input type="number" name="cep" maxlength="8" title="CEP" placeholder="12345678"/><br>
				<label class="campo_opcional">Numero: </label> <input type="number" name="nuCasa" maxlength="5" title="Numero" placeholder="1234"/><br>
				
			</div>
		</fieldset>
		
		<fieldset>
			<legend>Segurança</legend>
			<div>
				<label class="campo_obrigatorio">E-mail: </label> 
					<input type="email" name="email" maxlength="50" placeholder="exemplo@provedor.com" title="exemplo@provedor.com"/>
				</label><br>
				<label class="campo_obrigatorio">Senha: </label> <input type="password" name="senha" title="Senha" /><br>
				<label class="campo_obrigatorio">Confirmar Senha: </label> <input type="password" name="senha_confirm" title="Confirmação Senha"/><br>
			</div>
		</fieldset>
		<input type="button" title="Cadastrar" onclick="cadastrar()" value="Enviar"/> <input type="reset" title="Limpar" value="Limpar"/>
	</form>
</body>
</html>