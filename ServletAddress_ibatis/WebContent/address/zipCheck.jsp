<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(document).ready(function(){
	$("#send").click(sendIt);
	$("#dong").keydown(function(e){
		if(e.keyCode==13){
			sendIt();
			return false;
		
	}
});

	$("#area").on("click","tr",function(){
		var address=$("td:eq(1)",this).text()+" "+
					$("td:eq(2)",this).text()+" "+
					$("td:eq(3)",this).text()+" "+
					$("td:eq(4)",this).text();
		alert(address);	
		$(opener.document).find("#zipcode").val($("td:eq(0)",this).text());
		$(opener.document).find("#addr").val(address);
		self.close();
	});	//area
});



//동 검색
function sendIt(){
	if($("#dong").val()==""){
		alert("동이름 입력하세요");
		return false;
	}
	
	$.get("zipCheck.iba",{"dong":$("#dong").val()},
		function(data){
			$("#area").html(data);
		}
	);  //get
}

</script>
</head>
<body>
<form>
<table>
<tr>
	<td>동이름 입력 <input type="text" name="dong" id="dong">
	<input type="button" id="send" value="검색">
	</td>
</tr>
</table>
<div id="area"></div>

</form>
</body>
</html>