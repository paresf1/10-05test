<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	Date now = new Date();
	request.setAttribute("now", now);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>boardList</title>
<%@ include file="/layout/commonLib.jsp" %>
<style>
	#list{
		padding:50px;
		padding-left: 300px;
	}
</style>


</head>
<body>
<%@ include file = "/layout/header.jsp" %>
<div class="container-fluid">
	<div class="row">
			
		<div class="col-sm-3 col-md-2 sidebar">
		<%@ include file = "/layout/left.jsp" %>
		</div>
	
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
		<tr>
			<th>게시글번호</th>
			<th>제목</th>
			<th>작성자 아이디</th>
			<th>작성일시</th>
		</tr>
		
		<tbody id="memberList">
		<c:forEach items="${boardList }" var="list">
		<tr>
			<td>${list.board_seq }</td>
			<td>${list.board_title }</td>
			<td>${list.user_id }</td>
			<td>${list.create_date }</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	
		
		
</body>
</html>






