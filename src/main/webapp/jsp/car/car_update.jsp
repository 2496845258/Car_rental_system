<%@page import="com.vo.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新车辆信息</title>
	</head>
	<body>
		<%
			Car car = (Car)request.getAttribute("car");
		%>
	
		<form action="/Car_rental_system/Car_Update_Servlet" method="post">
			编号：<input type="text" name="carid" readonly="readonly" value=<%=car.getCarid() %>><br>
			车牌号：<input type="text" name="license" value=<%=car.getLicense() %>><br>
			租金：<input type="text" name="rent" value=<%=car.getRent() %> ><br>
			<input type="submit" value="更新">
		</form>
		
		<% 
			String url = "/Car_rental_system/Car_Delete_Servlet?id=" + car.getCarid();
		%>
		<a href=<%=url %>>
			<input name="删除" type="button" id="btn1" title="不知道是什么意思" value="删除" />
		</a>
	</body>
</html>