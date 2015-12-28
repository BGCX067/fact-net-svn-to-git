<%@ page  isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adminstração UniServer e UniDroid</title>

<script src="<%=request.getContextPath() %>/resources/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.10.2.custom.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/interno.js"></script>

<link href="<%=request.getContextPath() %>/resources/css/interno.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.2.custom.css" rel="stylesheet">

</head>
<body onload="history.forward()">
<div id="all">
	<div id="header">
		<h1 align="left">UniServer Dashboard</h1>
		<div align="right" id="area_usuario">
			<span>Bem-vindo Sr(a), </span><c:out value="${sessionScope.adminstrador.nome}"/> 
			<a href="/UniServer/admin/login.do?acao=logout">Sair</a>
		</div>
	</div>
	
	<div id="menu" style="float: left;border:1px solid #000;padding: 10px;margin: 0 20px 0 0">
		<ul>
			<li><a onclick="abrirConteudo('/UniServer/admin/curso.do?acao=abrirTelaCurso')" href="javascript:void(0)">Cadastro de Cursos</a></li>
			<li><a onclick="abrirConteudo('/UniServer/admin/professor.do?acao=abrirTelaProfessor')" href="javascript:void(0)">Cadastro de Professores</a></li>
			<li><a onclick="abrirConteudo('/UniServer/admin/disciplina.do?acao=abrirTelaDisciplina')" href="javascript:void(0)">Cadastro de Disciplinas</a></li>
			<li><a onclick="abrirConteudo('/UniServer/admin/turma.do?acao=abrirTelaTurma')" href="javascript:void(0)">Cadastro de Turma</a></li>
		</ul>
	</div>
	<div id="content" style="float: left">
		Conteudo do Site
	</div>
</div>
</body>
</html>