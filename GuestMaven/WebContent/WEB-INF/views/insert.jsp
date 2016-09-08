<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
	$(document).ready(function(){
		$("#submit").click(sendit);
		getData(1,"","");
		$("#search").click(function(){
			getData(1,"","");
		});
	});
	
	function getData(pageNum,field,word){
		word=(word=="")?$("#word").val():word;
		field=(field=="")?$("#field").val():field;
		$("#result").load("list?pageNum="+pageNum+"&field="+field+"&word="+word
				,function(data){
			$("#result").html(data);
		});
	}

	
	function sendit(){
		var name=$("#name").val();
		var content=$("#content").val();
		var grade = $("input:radio[name='grade']:checked").val();
		var postString="name="+name+"&content="+content+"&grade="+grade;
		$.ajax({
			type:"post",
			url:"insert",
			data:postString,
			success:function(data){
				$("#result").html(data);
			},
			beforeSend:show,
			error:function(e){
				alert("error:"+e);
			}
		});
	}
	
	function show(){
		if(!$("#name").val()){
			alert("글쓴이를 입력하세요");
			$("#name").focus();
			return false;
		}
		if(!$("#content").val()){
			alert("내용을 입력하세요");
			$("#content").focus();
			return false;
		}
		if($("input:radio[name='grade']:checked").length==0){
			alert("평가를 해 주세요");
			$("#grade").focus(); 
			return false;
		}
		return true;	
	}
	
	function view(num){
		$.ajax({
			type:"get",
			url:"view",
			data:"num="+num,
			success:function(data){
				$("#view").html(data);
			},
			error:function(e){
				alert("error:"+e);
			}
		});
	}
	function del(num){
		if(confirm("정말로 삭제하시겠습니까?")){
			$.get("delete",{"num":num},function(data){
				$("#result").html(data);
			});
		}
		return false;
	}
</script>
</head>
<body>
<div align="right">
	<c:if test="${loginSession==null}">
		<a href="admin">[관리자]</a>
	</c:if>
	<c:if test="${loginSession!=null}">
		<a href="logout">[로그아웃]</a>
	</c:if>
</div>
<form id="frm" method="post" action="insert">
	<table>
	<tr>
		<td>글쓴이</td>
		<td>
			<input type="text" id="name" name="name" maxlength="20">
			*20글자 이내(<span id="nameCount" style="color:red;">0</span>)
		</td>
	</tr>
	<tr>
		<td>내   용 </td>
		<td>
			<input type="text" id="content" name="content" size="100" maxlength="70">
			*70글자 이내(<span id="contentCount" style="color:red;">0</span>)
		</td>
	</tr>
	<tr>
		<td>평가</td>
		<td>
		<input type="radio" value="excellent" name="grade">아주잘함(excellent)
		<input type="radio" value="good" name="grade">잘함(good)
		<input type="radio" value="normal" name="grade">보통(normal)
		<input type="radio" value="fail" name="grade">노력(fail)<br>
		
		</td>
	</tr>
	<tr>
		<td colspan=2><input type="button" value="입력" id="submit"></td>
	</tr>
	</table>
</form>
<br><br><br>
<div id="result"></div>
<hr>
<div id="view"></div>
<form align="right">
	<br>
	<select name="field" id="field">
		<option value="name">이름</option>
		<option value="content">내용</option>
	</select>
	<input type="text" id="word" name="word">
	<input type="button" value="찾기" id="search">
</form>
</body>
</html>