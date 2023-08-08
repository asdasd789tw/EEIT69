<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script>
			function test1() {
				$('#id1').load("Yuan53.jsp?max=" + $('#max').val());
			}
			function test2() {
				$.get("Yuan53.jsp?max=" + $('#max').val(),
					function(data , status){
						if(status =='success'){
							$('#id1').html(data);
						}
					});
			}
			
			function test3() {
				$.post("Yuan53.jsp",
					{
						"max" : $('#max').val()
					},
					function(data , status){
						if(status =='success'){
							$('#id1').html(data);
						}
					});
			}
			
			function test4() {
				$.ajax({
					url: "Yuan53.jsp?max=" + $('#max').val(),
					success: function(res){
						$('#id1').html(res);
					}					
				})
			}
			
			function test5() {
				$.ajax({
					url: "Yuan53.jsp",
					method : "post",
					data : {
						"max" : $('#max').val()
					},
					success: function(res){
						$('#id1').html(res);
					}					
				})
			}
		</script>		
	</head>
	
	<body>
		<input type="number" id="max"><br>
		<button onclick="test1()">Test1</button><br>
		<button onclick="test2()">Test2</button><br>
		<button onclick="test3()">Test3</button><br>
		<button onclick="test4()">Test4</button><br>
		<button onclick="test5()">Test5</button><br>
		<div id="id1"></div>
	</body>
</html>