<%@page import="com.vo.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>插入车辆信息</title>
	</head>
	<body>

	
		<form action="/Car_rental_system/Car_Insert_Servlet" method="post">
			车牌号：<input type="text" name="license" ><br>
			租金：<input type="text" name="rent"><br>
			<input type="submit" value="插入">
		</form>

	</body>
</html>