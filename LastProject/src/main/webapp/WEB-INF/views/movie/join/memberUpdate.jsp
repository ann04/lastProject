<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원의 정보 입력 폼</title>
<style>
.btn_join{
	font-weight:bold;
 	background: #3DB7CC;
 	border: 1px solid #3DB7CC;
    width: 49%;
	height: 61px;
}
#id { height: 30px; } #pwd { height: 30px; } #repwd { height: 30px; } #name { height: 30px; } #jumin { height: 30px; } #zipcode { height: 30px; } #addr { height: 30px; } #email { height: 30px; } #tel { height: 30px; }
</style>
<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" type="text/css" href="../css/mobile.css" media="screen and (max-width : 568px)">
	<script type="text/javascript" src="../js/mobile.js"></script>
	<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
 <script>
 $(document).ready(function(){
	 $("#btnZip").click(function(){
		 window.open("zipCheckform","","width=700 height=500 scrollbars=yes");
	 });

  $('#pwd').keyup(function(){
	   $('font[name=check]').text('');
	  }); //#pwd.keyup

	  $('#repwd').keyup(function(){
	   if($('#pwd').val()!=$('#repwd').val()){
	    $('font[name=check]').text('');
	    $('font[name=check]').html("암호틀림");
	   }else{
	    $('font[name=check]').text('');
	    $('font[name=check]').html("암호맞음");
	   }
	  }); //#repwd.keyup
	 });
	 function checkDel(id){
		 if(confirm("정말 탈퇴하시겠습니까?")){
			 location.href="memberdel?id="+id;
		 }
	 }
 </script>
 

</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h2 align="center">가입정보입력</h2>
<form action="userupdate" method="post" >
<table border="1" width="400" height="400" align="center">
	<tr>
		<td><input type="text" id="id" title="아이디 입력"
maxlength="40" name="id" placeholder="아이디" size="30" readonly="readonly" value="${uInfo.id}"/></td>
	</tr>
	<tr>		
		<td><input type="password" id="pwd" title="변경 비밀번호 입력"
maxlength="40" name="password" placeholder="비밀번호 숫자만 사용!" size="30" /></td>
	</tr>
	<tr>		
		<td><input type="text" id="repwd" title="변경 비밀번호 재입력"
maxlength="40" name="repwd" placeholder="비밀번호 재확인" size="30" />
<font name="check" size="2" color="red"></font> </td>
	</tr>	
	<tr>
		<td><input type="text" id="name" title="이름"
maxlength="40" name="name" placeholder="이름" size="30" value="${uInfo.name}" /></td>
	</tr>	
	<tr>
		<td><input type="date" id="jumin" title="생년월일"
maxlength="40" name="jumin" placeholder="생년월일 ex)1991년 1월 1일 -> 19910101" readonly="readonly" value="${uInfo.jumin}"/></td>
	</tr>
	<tr>
        <td><input type="text" id="zipcode" title="우편번호"
maxlength="40" name="zipcode" placeholder="우편번호" value="${uInfo.zipcode}"/>
        <input type="button" value="검색" id="btnZip" ></td>
	</tr>
	<tr> 
    	<td><input type="text" id="addr" title="주소"
maxlength="40" name="addr" placeholder="주소" size="50" value="${uInfo.addr}" /></td>
	</tr>	 
	<tr>
		<td><input type="email" id="email" title="이메일"
maxlength="40" name="email" placeholder="이메일" size="50" value="${uInfo.email}"/></td>
	</tr>
	<tr>
		<td><input type="tel" id="tel" title="휴대전화 번호"
maxlength="40" name="tel" placeholder="휴대전화 번호 ex)010-6666-7777" size="50" value="${uInfo.tel}"/></td>
	</tr>
	<tr>
		<td align="center" colspan="2"><input type="submit" value="수정"  class="btn_join">
		<input type="button" value="회원탈퇴" onclick="checkDel('${uInfo.id}')" class="btn_join"></td>

	</tr>
	
</table>
</form>
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
<jsp:include page="../footer.jsp"/>
</body>
</html>