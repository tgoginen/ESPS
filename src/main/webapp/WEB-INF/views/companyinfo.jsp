<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
You requested quote for ${model.companySymbol}</br>
<c:choose>
	<c:when test="${model.historicalQuotes != null}">
	   <c:forEach items="${model.historicalQuotes}" var="item">
	       <h5> ${item.date}  :   ${item.price}</h5>
	   </c:forEach>
	</c:when>
</c:choose>
</body>
</html>