<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div>
	<form method="post"  action="/UniServer/admin/disciplina.do?acao=salvarDisciplina" >
		<label>Nome:</label>
		<input type="text" name="nome" title="Informe o nome da disciplina">
		<br>
		
		<label>Professor:</label>
		<select name="matriculaProfessor" title="Selecione o professor responsavel pela disciplina">
			    <option value="-1">Selecione</option>
			<c:forEach items="${requestScope.listaProfessores}" var="prof">
				<option value='<c:out value="${prof.matricula}"/>'><c:out value="${prof.nome}"/></option>
			</c:forEach>
		</select>
		<br>
		<label>Curso Alvo:</label>
		<select name="cursoAlvo" title="Selecione o curso alvo da disciplina">
			    <option value="-1">Selecione</option>
			<c:forEach items="${requestScope.listaCursos}" var="curso">
				<option value='<c:out value="${curso.id}"/>'><c:out value="${curso.nome}"/></option>
			</c:forEach>
		</select>
		<br>
		
		<label>Descrição:</label><br/>
		<textarea rows="8" cols="15" name="descricao"></textarea>
		<br>
		
		<input type="button" value="Cadastrar" onclick="salvarDisciplina()">
	</form>
</div>