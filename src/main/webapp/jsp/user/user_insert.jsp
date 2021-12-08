<%@page import="com.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>插入用户信息</title>
	</head>
	<body>

	
		<form action="/Car_rental_system/User_Insert_Servlet" method="post">
			账号：<input type="text" name="account" ><br>
			密码：<input type="text" name="passwor"><br>
			姓名：<input type="text" name="username"><br>
			电话：<input type="text" name="telephone"><br>
			<input type="submit" value="插入">
		</form>

	</body>
</html>