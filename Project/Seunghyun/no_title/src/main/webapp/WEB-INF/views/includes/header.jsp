<%@ page language="java"  pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>temporary title</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/css/style.css">

</head>


<body>
<div class="header_frame">
	<div id="nav">
		<ul id="nav_ul">
			<li id="nav_li_home">홈으로</li>
			<li id="nav_li_problem">문제</li>
			<li id="nav_li_problemSet">문제집</li>
			<li id="nav_li_lanking">랭킹</li>
		</ul>
	</div>
	
	<div id="user_bar">
		<sec:authorize access="isAnonymous()">
		<ul id="user_bar_ul">
			<li id="user_bar_li_register">회원 가입</li>
			<li id="user_bar_li_login">로그인</li>
		</ul>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
		<ul id="user_bar_ul">
			<li id="user_bar_li_info">정보</li>
			<li id="user_bar_li_logout">로그아웃</li>
		</ul>
		</sec:authorize>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$("#nav_li_home").on("click",function(){
			self.location = "/";
		});	
		$("#nav_li_problem").on("click",function(){
			self.location = "/problem/all";
		});	
		
		$("#user_bar_li_register").on("click",function(){
			self.location = "/register";
		});		
		$("#user_bar_li_login").on("click",function(){
			self.location = "/customLogin";
		});		
		$("#user_bar_li_logout").on("click",function(){
			self.location = "/customLogout";
		});		
		$("#user_bar_li_info").on("click",function(){
			self.location = "/member/info";
		});		
	});

	
</script>