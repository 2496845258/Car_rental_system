<%@page import="com.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>插入订单信息</title>
	</head>
	<body>

	
		<form action="/Car_rental_system/Order_Insert_Servlet" method="post">
			用户编号：<input type="text" name="userid" ><br>
			车辆编号：<input type="text" name="carid"><br>
			用户姓名：<input type="text" name="username"><br>
			<input type="submit" value="插入">
		</form>

	</body>
</html>