<%@taglib uri="/WEB-INF/struts-logic" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html" prefix="html" %>
<%@taglib uri="/WEB-INF/c" prefix="c" %>
<%@ page isELIgnored ="false" %> 

<div id="menu_header">
	<script type="text/javascript">

		function abrirLogin(){
			$(document).ready(function(){
				$("#login").toggle("slow", function(){
					$("input[name=login]").focus();
				});
			});
		}
		
		function efetuar_login(){
			var dataForm = $("#login_form").serialize();
			jQuery.ajax({
				type: "POST",
				url: "cadastro.do?acao=login",
				datatype: "html",
				data: dataForm,
				success: function(data, textStatus, jqXHR){
					document.location.reload();
				},
				error: function(request, status, error){
					alert(request.responseText);
				}
			});
		}

	</script>
	<c:set var="linkEndereco" 
		   value="http://maps.google.com.br/maps?f=q&source=s_q&hl=pt-BR&geocode=&q=Alameda+Santo+Amaro+-+Santo+Amaro,600+S%C3%A3o+Paulo&aq=&sll=-23.660567,-46.704738&sspn=0.01138,0.013797&vpsrc=0&ie=UTF8&hq=&hnear=Alameda+Santo+Amaro,+600+-+Santo+Amaro,+S%C3%A3o+Paulo,+04745-001&t=m&ll=-23.660563,-46.704769&spn=0.037736,0.054932&z=14&iwloc=A&output=embed" 
		   scope="page"/>
	
	<%-- Cria a variavel 'permissoes', e define o valor dela para o objeto 'PermissoesDTO' --%>
	<logic:empty name="PESSOA" scope="session">
		<c:set var="permissoes" value="null" scope="page"/>
	</logic:empty>
	<logic:notEmpty name="PESSOA" scope="session">
		<c:set var="permissoes" value="${sessionScope.PESSOA.permissoes}" scope="page"/>
	</logic:notEmpty>

	<%-- Verifica se a variavel 'permissoes' é nula para exibir o conteudo padrão --%>
	<logic:equal value="null" name="permissoes" scope="page">
		
		<li><a href="<bean:write name="linkEndereco"/>" rel="shadowbox" >Localização</a></li>
        <li><a href="cadastro.do?acao=iniciarCadastro" rel="shadowbox">Registrar</a></li> 
		<li><a href="javascript:void(0)" onclick="abrirLogin()" >Minha Conta</a>
				<div id="login" style="display:none;">
					<form action="" id="login_form">
						<label>Login: <input name="login" type="text"/></label><br>
						<label>Senha: <input name="senha" type="password"/></label><br>
						<label><input type="button" value="Login" onclick="efetuar_login()" /></label>
						<label><input type="button" value="Cancelar" onclick="abrirLogin()" /></label>
				     </form>
				</div>
		</li>
	</logic:equal>
	
	<%-- Caso a variavel não seja nula é realizada uma verificação para poder exibir o conteudo correto --%>
	<logic:notEqual value="null" name="permissoes" scope="page">
		<c:choose>
		<c:when test="${permissoes.acessarComercial && !permissoes.acessarAdminstracao && !permissoes.acessarRH && 
					  !permissoes.acessarEstoque && !permissoes.acessarCMS && !permissoes.acessarRelatorios && 
					  !permissoes.acessarFaturas}">
					  
			<li><a href="#" id="carrinho">Carrinho</a><img src="images/Seta_Carrinho.png" style="margin:0 0 0 -18px;" /></li> 
			<li><a href="<bean:write name="linkEndereco"/>" rel="shadowbox" >Localização</a></li>
			<li><a href="pessoal.do?acao=conta&id=<bean:write name="PESSOA" property="id"/>">Minha Conta</a></li>
			<li><a href="cadastro.do">Logout</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<bean:write name="linkEndereco"/>" rel="shadowbox" >Localizacao</a></li>
			<li><a href="rh.do?acao=conta&id=<bean:write name="PESSOA" property="id"/>">Minhas Informações</a></li>
			<li><a href="cadastro.do">Logout</a></li>
		</c:otherwise>
		</c:choose>
	</logic:notEqual>
</div>