<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard taglib</title>
</head>
<body>

	<c:import url="loggedUser-logout-top.jsp" />
	
	<br/>
	<br/>
	<br/>

	<c:if test="${not empty companyName }">
        Empresa ${companyName } cadastrada com sucesso!
    </c:if>
    	
    <c:if test="${empty companyName }">
        Nenhuma empresa cadastrada!
    </c:if>
    
    <br/>
    <br/>

	Lista de empresas:
	
	<br/>
	
	<ul>
		<c:forEach items="${companies}" var="company">
			
			<li>${company.name } - <fmt:formatDate value="${company.openingDate }" pattern="dd/MM/yyyy"/> - 
				<a href="/manager/entry?action=DisplayCompany&id=${company.id }">Editar</a>
				<a href="/manager/entry?action=DeleteCompany&id=${company.id }">Remover</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>