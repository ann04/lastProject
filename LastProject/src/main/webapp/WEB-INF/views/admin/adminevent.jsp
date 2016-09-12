<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.ad_header ul li{
		display:inline;
		list-style: none;
		padding:40px;
	}
	.
</style>
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
	<input type="button" value="등록하기" onclick="location.href='moviethea.go'">
	<div id="body">
		<h1><span>movie</span></h1>
		<ul class="gallery">
			<c:forEach items="${mv}" var="m">
				<li>
					<a href="adminmovieview.go?mid=${m.mid}">
						<img src="../movie/images/${m.img}" alt=""><br>
						${m.title}
					</a>
				</li>
			</c:forEach>			
		</ul>
	</div>
</body>
</html>