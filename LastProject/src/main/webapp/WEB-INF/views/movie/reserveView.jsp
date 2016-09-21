<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css" media="screen and (max-width : 568px)">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<title>영화예매</title>
<script>
	var tid="";
	var tname="";
	var mid="";
	var title="";
	var data="";
	var flag=0;
	var dt="";
	var time="";
	var perCnt="";
	$(document).ready(function(){
		$(".person_choose button").prop("disabled", true);
		$(".movie_choose div").click(function(){
			$(".movie_choose div").css("background","#ffffff");
			$(this).css("background","#dddddd");
			mid=$(this).attr("id");
			title=$(this).text();
			$(".reserveInfo img").prop("src","/resources/images/"+$(this).prop("title"));
			$(".reserveInfo b").eq(0).text(title);
			viewThea();
		});
		$(".person_choose button").click(function(){
			perCnt = $(this).text();
			$(".reserveInfo b").eq(4).text(perCnt+"명");
			
		});
	});
	//영화를 선택 했을 때 영화에 따른 영화관 불러오기
	function viewThea(){
		$.get("reserveview?mid="+mid,
			function(data){
				$(".cienma_choose").html(data);
			}
		);
	}
	//영화관 클릭 이벤트
	function theaClick(t){
		$(".cienma_choose div").css("background","#ffffff");
		$(t).css("background","#dddddd")
		tid=$(t).attr("id");
		tname=$(t).text();
		$(".reserveInfo b").eq(1).text(tname);
		viewdate();
	}
	//영화를 선택하고 영화관을 선택하면 가능 시간 불러오기
	function viewdate(){
		$.ajax({
			type:"get",
			url:"reservedate",
			data:"tid="+tid+"&mid="+mid,
			success:function(data){
				$(".time_choose").html(data);
				$(".person_choose button").prop("disabled", false);
			},
			error:function(e){
				alert("error:"+e);
			}
		});	
	}
	//선택된 날짜와 오늘 날짜 비교
	function dateCheck(date){
		dt=$(date).val();
		var today = new Date();  
		var dateArray = dt.split("-");  
		var dateObj = new Date(dateArray[0], Number(dateArray[1])-1, dateArray[2]);
		if(today.getTime()>dateObj.getTime()){
			alert("오늘 이전 날짜는 선택 불가 합니다.");
			return false;
		}
		flag=1;
		$(".reserveInfo b").eq(2).text(dt);
		return true;
		//var betweenDay = (today.getTime() - dateObj.getTime())/1000/60/60/24;    
	}
	
	function dateSave(tm){
		if(dt==""){
			alert("날짜를 선택해 주세요");
		}
		time=tm;
		$(".reserveInfo b").eq(3).text(time);
		return false;
	} 
	
	function resultV(){
		data ="mid="+mid+"&cid="+$(".mc").attr("id")+"&viewdate="+dt+" "+time+"&pcnt="+perCnt;
		location.href="reserveseat?"+data;
	}

</script>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<!-- 예매시작 -->
	<div class="cntnt">
		<div class="reserve">
			<!-- 날짜 선택 -->
			<div class="date_choose">
				<span>날짜선택</span>
				<input type="date" id="date" onchange="dateCheck(this)">
			</div>
			
			<!-- 영화/영화관 선택 -->
			<div class="mov_cin">
				<div class="movie_choose">
					<span>영화선택</span>
					<c:forEach items="${movie}" var="m">
						<div id="${m.mid}" title="${m.img}">
							${m.title}
						</div>
					</c:forEach>
				</div>
				<div class="cienma_choose">
					<span>영화관선택</span>
					<c:forEach items="${theater}" var="t">
						<div id="${t.tid}" onclick="javascript:theaClick(${t.tid})">
							${t.tname}
						</div>
					</c:forEach>
				</div>
			</div>
			
			<!-- 시간/인원수 선택 -->
			<div class="time_person">
				<div class="time_choose">
					<span>시간선택</span>
				</div>
				<div class="person_choose">
					<span>인원수선택</span>
					<button>1</button>
					<button>2</button>
					<button>3</button>
					<button>4</button>
					<button>5</button>
				</div>
			</div>
		</div>
		<div class="result">
			<div class="reserveInfo">
				<img src=""><br><br>
				<b></b><br><br>
				극장:<b></b><br><br>
				날짜:<b></b><b></b><br><br>
				인원:<b></b><br><br>
				<button id='reserve' onclick='resultV()'>예매하기</button>
			</div>
		   	
		</div>
	</div>
	<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<jsp:include page="footer.jsp"/>
</body>
</html>