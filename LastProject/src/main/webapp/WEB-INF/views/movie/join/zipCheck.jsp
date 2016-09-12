<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script   src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(document).ready(function(){
	$("#send").click(sendIt);
	$("#dong").keydown(function(e){
		if(e.keyCode==13){
			sendIt();
			return false;
		}
	});//keydown
	
	 $("#area").on("click","tr",function(){
		 var address=$("td:eq(1)",this).text()+"  "+
									 $("td:eq(2)",this).text()+"  "+
									 $("td:eq(3)",this).text()+"  "+
									 $("td:eq(4)",this).text();
		 $(opener.document).find("#zipcode").val($("td:eq(0)",this).text());
		 $(opener.document).find("#addr").val(address);
		 self.close();
		 
	 });//area
});  //document

//동검색
function sendIt(){
	if($("#dong").val()==""){
		alert("동이름을 입력하세요");
		return false;
	}
	$.get("zipCheck.iba",{"dong" : $("#dong").val() },
	         function(data){
		          $("#area").html(data);
	       }		
	); //get
}  //function
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
</form>
*  검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.<p>
<div id="area"></div>

</body>
</html>