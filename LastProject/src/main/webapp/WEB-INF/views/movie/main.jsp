<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<!-- Website Template by freewebsitetemplates.com -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>영화보자</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css" media="screen and (max-width : 568px)">
	<script type="text/javascript" src="/resources/js/mobile.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div id="body">
		<div id="featured">
			<img src="/resources/images/main.jpg" alt="">
			<div>
				<h2>Suicide Squad</h2>
				<span>Our website templates are created with</span>
				<span>inspiration, checked for quality and originality</span>
				<span>and meticulously sliced and coded.</span>
			</div>
		</div>
		<ul>
			<li>
				<a href="movieview.go?mid=11">
					<img src="/resources/images/movie_image1.jpg" alt="">
					<span>터널</span>
				</a>
			</li>
			<li>
				<a href="movieview.go?mid=16">
					<img src="/resources/images/TrainToBusan.jpg" alt="">
					<span>부산행</span>
				</a>
			</li>
			<li>
				<a href="movieview.go?mid=15">
					<img src="/resources/images/OperationChromite.jpg" alt="">
					<span>인천상륙작전</span>
				</a>
			</li>
			<li>
				<a href="movieview.go?mid=17">
					<img src="/resources/images/mov05.jpg" alt="">
					<span>수어사이드 스쿼드</span>
				</a>
			</li>
		</ul>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
