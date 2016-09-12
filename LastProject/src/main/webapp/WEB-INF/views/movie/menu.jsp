<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>영화보자</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css" media="screen and (max-width : 568px)">
<script type="text/javascript" src="/resources/js/mobile.js"></script>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<script>
	function layer_open_me(el,cn){
			var temp = $('#' + el);
			var bg = temp.prev().hasClass('bg');    //dimmed 레이어를 감지하기 위한 boolean 변수
			 
			if(bg){
				$('.layer').fadeIn();   //'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다.
			}else{
				temp.fadeIn();
			}
		 
		// 화면의 중앙에 레이어를 띄운다.
			if (temp.outerHeight() < $(document).height() )
				temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
			else temp.css('top', '0px');
			if (temp.outerWidth() < $(document).width() )
				temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
			else temp.css('left', '0px');
			 
			temp.find('a.cbtn').click(function(e){
				if(bg){
					$('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다.
				}else{
					temp.fadeOut();
				}
				e.preventDefault();
			});
			
			temp.find('a.lgbtn').click(function(e){
				if(bg){
					$('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다.
					if(cn==1){
						temp.find('a.jobtn').text("nono");
						$("#frm").prop("action", "adminlogin.go");
						alert($("#frm").prop("action"));
					}
					$("#frm").submit();
				}else{
					temp.fadeOut();
				}
				e.preventDefault();
			});
			
			temp.find('a.jobtn').click(function(e){
				if(bg){
					location.href="join/JoinForm.jsp";
					$('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다.
				}else{
					temp.fadeOut();
				}
				e.preventDefault();
			});
			 
			$('.layer .bg').click(function(e){  //배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
				$('.layer').fadeOut();
				e.preventDefault();
			});	
	} 
	function loginCheck(userId){
		/* if(userId==null){
			alert("로그인 후 예매 가능합니다");
			return false;
		} */
		location.href="reserveview";
	}
</script>
	
	
</head>



<body>
<div id="header">
		<ul id="navigation">
			<li class="selected">
				<a href="/">home</a>
			</li>
			<li>
				<a href="movieall">movie</a>
			</li>
			<li>
				<a href="#" onclick="loginCheck(${userId})">reservation</a>
			</li>
			<li>
				<a href="blog.html">event</a>
			</li>
			
			<c:if test="${userId==null}">
			<li>
				<a href="#" class="btn-example" onclick="layer_open_me('layer2',0);return false;">join</a>
				<div class="layer">
					<div class="bg"></div>
						<div id="layer2" class="pop-layer">
							<div class="pop-container">
								<div class="pop-conts">
									<!--content //-->
									<p class="ctxt mb20">Anscreen<br></p>
									<form action="login.go" method="post" id="frm">
									<input type="text" id="id" title="아이디 입력"
									 maxlength="20" name="id" placeholder="아이디" /><br><br>
									<input type="password" id="footer-book-pw" title="비밀번호 입력"
									 maxlength="20" name="password" placeholder="비밀번호" />
									</form>
									<div class="btn-r">
										<a href="#" class="lgbtn">login</a>
										<a href="#" class="jobtn">Join</a>
										<a href="#" class="cbtn">Close</a>
									</div>
									<!--// content-->
								</div>
							</div>
						</div>
	</div>		
			</li>
			</c:if>
			<c:if test="${userId!=null}">
			<li>
				<a href="logout.go">logout</a>
			</li>
			<li>
				<a href="join/myPage.jsp">MyPage</a>
			</li>
			</c:if>
		</ul>
	</div>
</body>
</html>