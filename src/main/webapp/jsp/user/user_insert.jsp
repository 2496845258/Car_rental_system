<%@page import="com.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>插入用户信息</title>
		<style>
			*{
	            margin: 0;
	            padding: 0;
	        }       
			ol,ul{
				list-style-type:none;
			}
	        body{
	            background:#e3e4e5;
	        }
	        #header {
			    background-color:black;
			    color:white;
			    text-align:center;
			    padding:5px;
			    height:40px;
			}
			#top{
				height:100px;
				width:100%;
			}
			#top li{
				float:right;
				margin:0px 15px;
				line-height:60px;
			}
			#top li a{
				color:black;
				font-weight:bold;
				text-decoration: none;
			}
			#middle{
				height:430px;	
			}
			.login{
				position:absolute;
				top:46%;
				margin-top:-190px;
				left:50%;
				margin-left:-200px;
				width:400px;
				height:430px;
				border-radius:25px;
				text-align:center;
				padding:5px 40px;
				background-color:white;
			}
			input{
				background-color:white;
				width:60%;
				height:40px;
				margin-bottom:25px;
				border:none;
				border-bottom:2px solid silver;
				border-radius:5px;
				outline:none;
				font-size:15px;
		    }
			
		    p{
				font-size:30px;
				font-weight:500;
			}
			#btn{
				background-color:black;
				width:38%;
				height:48px;
				border-radius:8px;
				font-size:20px;
				font-weight:400;
				color:white
				
			}
			#btn:hover{
				background-color:#59c2a0;
			}
			#foot{
				height:40px;
			}
			#foot1{
				float:right;
				height:40px;
				width:100%;
				background-color:black;			    
			}
		</style>
	</head>
	<body>
	
		<div id="header">
			<h1>Insert</h1>
		</div>
		<div id="top">
			<ul class="right">
				<li><a href="#">主页</a></li>
							</ul>			
		</div>
		<div id="middle">
		
			
		<form action="/Car_rental_system/User_Insert_Servlet"  method="post" class="login">
			<br>
			
			<p>新增用户信息</p>
		
			<br>
			账号：<input type="text" name="account" ><br>
			密码：<input type="text" name="passwor"><br>
			姓名：<input type="text" name="username"><br>
			电话：<input type="text" name="telephone"><br>
			<input type="submit" value="插入">
		</form>

	 		
	 			
	 		
		</div>
		
		<div id="foot">
			
		</div>
		
		<div id="foot1">
	
		</div>
	</body>
</html>