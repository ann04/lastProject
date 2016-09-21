<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
<jsp:include page="menu.jsp"/>
	<div id="body">
		<h1><span>movie</span></h1>
		<ul class="gallery">
			<c:forEach items="${mv}" var="m">
				<li>
					<a href="movieview?mid=${m.mid}">
						<img src="/resources/images/${m.img}" alt=""><br>
						${m.title}
					</a>
				</li>
			</c:forEach>			
		</ul>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>