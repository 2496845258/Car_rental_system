<%@page import="com.vo.User"%>
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
				<td>账号</td>
				<td>密码</td>
				<td>电话</td>
		</tr><br>
					
				<%	
					
					ArrayList<User> arr = (ArrayList<User>)request.getAttribute("arr");
					Integer integer = (Integer)session.getAttribute("page");
					
					int j = 10*integer;
					for( int i = j; i<j+10; i++ ) {
						if ( i < arr.size()) {
				%>			
				<br>
				<tr>
							<td>
								<% 
									Integer id = arr.get(i).getUserid();
									String url = "/Car_rental_system/User_Id_Servlet?id=" + id;
								%>
								<a href=<%=url %> > <%=id %></a>
							</td>
							<td><%=arr.get(i).getAccount()%> </td>
							<td><%=arr.get(i).getPasswor()%> </td>
							<td><%=arr.get(i).getUsername()%> </td>
							<td><%=arr.get(i).getTelephone()%> </td>
								
				</tr>
				<%
	
						}
					}
				%>
				
				<br>
				<a href="/Car_rental_system/jsp/user/user_insert.jsp">
					<input name="新增用户信息" type="button" id="btn1" title="不知道是什么意思" value="新增用户信息" />
				</a>
				
				
				<a href="/Car_rental_system/User_All_Servlet?value=0">
					<input name="上一页" type="button" id="btn1" title="不知道是什么意思" value="上一页" />
				</a>
				<a href="/Car_rental_system/User_All_Servlet?value=1">
					<input name="下一页" type="button" id="btn1" title="不知道是什么意思" value="下一页" />
				</a>
	</body>
</html>