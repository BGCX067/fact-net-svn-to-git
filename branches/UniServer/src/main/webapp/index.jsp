<%@ page  isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UniServer - Admin</title>

<script src="<%=request.getContextPath() %>/resources/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.10.2.custom.js"></script>

<link href="<%=request.getContextPath() %>/resources/css/interno.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/jquery-ui-1.10.2.custom.css" rel="stylesheet">
</head>
<body onload="history.forward()">

	<div  id="contentLoginForm" class="ui-dialog ui-widget ui-widget-content ui-corner-all">
		<c:if test="${requestScope.message ne null }">
			<div id="messages" class="ui-widget">
				<div class="ui-state-error ui-corner-all" style="padding: 5px 10px">
					<c:out value="${requestScope.message }"/>
				</div>
			</div>
			<br>
		</c:if>
		<form action="/UniServer/admin/login.do?acao=logar" id="loginForm" method="post">
			<table>
				<tr>
					<td>Login:</td>
					<td><input type="text" maxlength="50" name="login" title="Digite seu login"/></td>
				</tr>
				
				<tr>
					<td>Senha:</td>
					<td><input type="password" maxlength="50" name="senha" title="Informe sua senha"/></td>
				</tr>
			</table>
			
			<button  onclick="$('#loginForm').submit()" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only">
				<span class="ui-button-text">Logar</span>
			</button>
		</form>
	</div>
</body>
</html>