<%@page import="com.vo.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看车辆全部信息</title>
	</head>
	<body>
		<tr>
				<td>编号</td>
				<td>车牌</td>
				<td>租金</td>
		</tr><br>
					
				<%	
					
					ArrayList<Car> arr = (ArrayList<Car>)request.getAttribute("arr");
					Integer integer = (Integer)session.getAttribute("page");
					
					int j = 10*integer;
					for( int i = j; i<j+10; i++ ) {
						if ( i < arr.size()) {
				%>			
				<br>
				<tr>
							<td>
								<% 
									Integer id = arr.get(i).getCarid();
									String url = "/Car_rental_system/Car_Id_Servlet?id=" + id;
								%>
								<a href=<%=url %> > <%=id %></a>
							</td>
							<td><%=arr.get(i).getLicense()%> </td>
							<td><%=arr.get(i).getRent()%> </td>
								
				</tr>
				<%
	
						}
					}
				%>
				
				<br>
				<a href="/Car_rental_system/jsp/car/car_insert.jsp">
					<input name="新增汽车信息" type="button" id="btn1" title="不知道是什么意思" value="新增汽车信息" />
				</a>
				
				
				<a href="/Car_rental_system/Car_All_Servlet?value=0">
					<input name="上一页" type="button" id="btn1" title="不知道是什么意思" value="上一页" />
				</a>
				<a href="/Car_rental_system/Car_All_Servlet?value=1">
					<input name="下一页" type="button" id="btn1" title="不知道是什么意思" value="下一页" />
				</a>
				
				<br>
				<a href="/Car_rental_system/jsp/admin.jsp">
					<input name="主页" type="button" id="btn1" title="不知道是什么意思" value="主页" />
				</a>
	</body>
</html>