<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div>
	<form action="/UniServer/admin/turma.do?acao=salvarTurma">
		<label>Nº Sala:</label>
		<input type="text" name="noSala" title="Numero da Sala de Aula">
		<br>
		
		<label>Turma:</label>
		<input type="text" name="turma" title="Semestre ou Ano e letra da turma">
		<br>
		
		<label>Curso: </label>
		<select title="Curso da turma" name="curso" onchange="updateDisciplinas()" id="curso">
		    <option value="-1">Selecione</option>
		  <c:forEach items="${requestScope.listaCursos}" var="curso">
			<option value='<c:out value="${curso.id}" />'><c:out value="${curso.nome}"/></option>
		  </c:forEach>
		</select>
		<br>
		
		<label>Disciplinas:</label>
		<br/>
		<select id="disciplinas" multiple="multiple" name="disciplinas" style="visibility: hidden;"
				title="Possiveis disciplinas desta turma">
		</select>
		<br>
		<input type="button" value="Cadastrar" onclick="salvarTurma()">
		
	</form>
</div>