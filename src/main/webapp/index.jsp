<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	
	/* location.href = '${contextPath}/BoardProject/list.do';  */
	/* location.href = "${contextPath}/BoardProject/list.do";  */
</script>
</head>
<body>
	<a href= "${contextPath}/BoardProject/list.do">프리 리스트</a>
</body>
</html>