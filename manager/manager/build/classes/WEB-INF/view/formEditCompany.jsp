<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entry" var="linkEntryServlet"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:import url="loggedUser-logout-top.jsp" />


	<form action="${linkEntryServlet }" method="post">
	
		Nome: <input type="text" name="companyName" value="${company.name }"/><br />
		Data abertura: <input type="text" name="openingDate" value="<fmt:formatDate value="${company.openingDate }" pattern="dd/MM/yyyy"/>"/><br />
		<input type="hidden" name="id" value="${company.id }"/><br />
		<input type="hidden" name="action" value="EditCompany"/><br />
        <input type="submit" />
        
    </form>

</body>
</html>