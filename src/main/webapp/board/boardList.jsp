<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
</div>
</div>
<div id = "list">
	<table>
		<tr>
			<th>게시글번호</th>
			<th>제목</th>
			<th>작성자 아이디</th>
			<th>작성일시</th>
		</tr>
		
		<c:forEach items="${boardList }" var="list">
		<tr>
			<td>${list.board_seq }</td>
			<td>${list.board_title }</td>
			<td>${list.user_id }</td>
			<td>${list.create_date }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
		
		
</body>
</html>






