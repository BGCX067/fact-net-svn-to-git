<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div>
	<form action="UniServer/admin/curso.do" >
		<label>Curso: </label>
		<input type="text" maxlength="50" name="nmCurso" title="Nome do curso" id="nmCurso">
		
		<input type="button" value="Cadastrar"  onclick="salvarCurso()"/> 
	</form>
</div>