<%@taglib uri="/WEB-INF/c" prefix="c" %>
<%@ page isELIgnored ="false" %>
<a href="base_Principal.html"><img src="images/Logo.jpg" border="0" /></a>
        <p id="saudacao"><b>Bem-Vindo</b>, 
        	<c:choose>
        		<c:when test="${not empty sessionScope.PESSOA }">
        			<c:out value="${sessionScope.PESSOA.nome }"/>
        		</c:when>
        		<c:otherwise>
        			Visitante
        		</c:otherwise>	
        	</c:choose>
        <a href="javascript: createSearch()" id="pesquisa">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><br></p>
    </div>
    <div id="menu">
        <li><a href="#"> Home </a></li>
        <li><a href="#"> Promoções </a></li>
        <li><a href="#"> Categorias </a></li>
        <li><a href="#"> Sobre Nós </a></li>
        <li><a href="contato.html"> Contato</a><li>