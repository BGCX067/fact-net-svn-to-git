<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<form method="post" action="/UniServer/admin/professor.do?acao=salvarProfessor" id="formCurso">
		<label>Matricula: </label>
		<input type="text" name="matricula" title="Nº da matricula do professor">
		<br/>
		
		<label>Nome: </label>
		<input type="text" name="nome" title="Nome do professor">
		<br/>
		
		<label>Senha: </label>
		<input type="password" name="senha" title="Senha inicial do professor">
		<br/>
		
		<label>Confirmação: </label>
		<input type="password" name="senhaConfirm" title="Digite novamente a senha para confirmar">
		<br/>
		<input type="button" value="Cadastrar" onclick="salvarProfessor()">
	</form>
</div>