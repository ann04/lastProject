<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>상세화면</title>
<style>
.p{
	 	font-size: 14pt;
	 	margin: 15px;
	 	padding: 5px;
	 	font-weight: bold;
}
.d{
	 	font-size: 14pt;
	 	margin: 15px;
	 	padding: 5px;
 	
 }
 
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
	$().ready(function(){
		$("#upCount").on("click",function(){
			var price = Number($("#price").val()); 
			price = price+1;
			$("#price").val(price); 
			
			
			 var mon=Number($("#mon").text());
			$("#mon").text(mon+=17000);
			 
			 var god=Number($("#god").text());
			$("#god").text(god+=17000);
		
			$("#add").text(price);
			
			
		
		});
			$("#downCount").on("click",function(){
				var price = Number($("#price").val());
				price = price-1;
				if(price==0){
					alert("최소 수량 1개이상 입니다 ");
					return false;
				}
				$("#price").val(price);
				
				
			
				 var money=Number($("#mon").text());
				$("#mon").text(money-=17000);
				 
				var mon=Number($("#god").text());
				$("#god").text(mon-=17000);
				
				
				$("#add").text(price);
				
				
			});		
	
			
	});
	
	
	
   function buy(){
	location.href="../good/buyaddress.jsp"
	 
} 
  
</script>


</head>
<body>
<form method="post" action="insert1.go"> 
<input type="hidden" name ="productname" value="${arr.productname}">
<input type="hidden" name ="color" value="${arr.color}">
<input type="hidden" name ="price" value="${arr.price}">


<div style="width: 1250px; height: 800px;">
	<div style="width: 40%; height:100%;  float: left;"  >

		<img alt="bigView" style="size: auto;" src="http://www.mixxmix.com/web/product/big/201606/35756_shop1_233804.gif">
	</div>												
	<div style="width: 50%; height:100%; float: left;">
		<table>
			
			<tr>
			
				<td style="font-size: 20pt;">${arr.productname }</td>
			</tr>
				
			<tr>
				<td class="p"><font color="red">free(사이즈)</font></td>
			</tr>
				
			<tr>
				<td class="p"><Strong class="" id="money">${arr.price}</Strong></td>
			</tr>	
				
			<tr>
				<td class="p">판매가</td>
				<td class="p">${arr.price}</td>
			</tr>
				
	
								
			<tr>
				<td scope="row" class="d">Color</td>
				
				<td><select name="option"  id="option">
				<option value="Navy"  >${arr.color}</option>
				</select></td>
			</tr>				
			
			<tr class="option_product" data-option-index="1">
				<td><input type = "hidden" class="option">스트라이프 원피스<br>
				<span>Navy</span></td>
				<td>
					<input type="text" id="price" name="numbers" value="1"/>
					<a id="upCount" href="#">
						<img alt="up" src="http://img.echosting.cafe24.com/design/skin/default/product/btn_count_up.gif">
					</a>
					<a id="downCount" href="#">
						<img alt="down" src="http://img.echosting.cafe24.com/design/skin/default/product/btn_count_down.gif">
					</a>
				</td>
			 	
			 	
		 	<td><input type="hidden" id="price" ><span id="mon">${arr.price}</span></td>
					
			</tr>
			
		
			<tr align="right">
				<td  colspan=3><strong>총 상품금액(수량)</strong><span id="god">${arr.price}</span>(<span id="add">1</span>개)</td>
			</tr>
			<tr>
			<td> 
				<input type ="button" value="구매하기" onclick="buy()" id="buy2"><br>
				<a href=""><input type="submit"  value="장바구니에 담기"></a></td>
			</tr>
			</table>
		
		</div>
	</div>
</form>
</body>

</html>