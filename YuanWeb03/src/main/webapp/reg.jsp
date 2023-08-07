<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	const xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		console.log("==> " + xhttp.readyState)
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log("====> " + xhttp.status)
			//document.getElementById("here").innerHTML = xhttp.responseText
		}
	}//每個狀態變更都會執行function()
	
	xhttp.onload = callback;
	function callback() {
		console.log("callback()")
		document.getElementById("mesg").innerHTML = xhttp.responseText
	}//只在乎有沒有回來
	
	function test1() {
		xhttp.open("GET","checkRepeat.jsp")
		xhttp.send()
	}
	
	function checkAccount() {
		console.log("checkAccount()")
		let account = document.getElementById("account").value
		xhttp.open("GET","checkRepeat.jsp?account=" + account)
		xhttp.send()
	}

</script>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<input type="button" value="Test1" onclick="test1()"><br>
		<div id="here"></div>
		<hr>
		<form method="post">
			Account: <input type="text" id="account" name="account" onblur="checkAccount()">
			<span id="mesg"></span> <br	>
			Password: <input type="password" name="passwd"><br>
			Realname: <input type="text" name="cname"><br>
			<input type="submit" value="Register">		
		</form>

	</body>
</html>