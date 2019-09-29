<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		用户名:<input type="text" name="uname" id="uname" /><span></span>
		<br />
		密码:<input type="text" name="pwd" id="pwd" /><br />
		重复密码:<input type="text" name="repwd" id="repwd" /><br />
		email:<input type="text" name="email" id="email" /><br />
		<input type="submit" value="注册"/>
	</form>
	<script type="/ajax/WebContent/js/jquery-3.1.1.js"></script>
	<script>
	$(function(){
		$('form').on('blur','#uname',function(){
			var uname = $(this).val();
			$.ajax({
				url:'userServlet',
				type:'post',
				data:{
					"uname":uname
				},
				success:function(data){
					console.log(data);
				},
				error:function(){
					
				}
			})
		})
	})
	
	</script>
</body>
</html>