<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
</script>
</head>
<body>
<c:if test="${msg!=null}">
	<script>
		alert("${msg}");
		location.href="/";
	</script>
</c:if>
<c:if test="${loginsession!=null}">
	<script>
		location.href="/";
	</script>
</c:if>
</body>
</html>