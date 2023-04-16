<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
		Nome: <input type="text" name="companyName" />
		Data abertura: <input type="text" name="openingDate" />
		<input type="hidden" name="action" value="NewCompany" />
        <input type="submit" />
        
    </form>

</body>
</html>