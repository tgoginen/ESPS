<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company List  </title>
</head>
<body>
<h2>The following is the list of companies we support </h2>
<h1>donnnnne</h1>

<c:choose>
		<c:when
			test="${model.getCompanyInfoList() != null}">
			<c:forEach
				items="${model.getCompanyInfoList()}"
				var="item">
			<h2> ${item.companySymbol }   ${item.getCompanyName() }</h2>
			</c:forEach>
		<%-- 	<c:forEach
				items="${model.getCompanyInfoList()}"
				var="item">
			<h2> ${items.getCompanySymbol() }</h2>
			</c:forEach> --%>
		</c:when>
	</c:choose>
	

</body>
</html>