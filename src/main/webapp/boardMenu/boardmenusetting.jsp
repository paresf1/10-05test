<%@page import="kr.or.ddit.model.BoardMenuVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/layout/commonLib.jsp" %>
</head>
<body>
<%@ include file = "/layout/header.jsp" %>
	
<script>
	

</script>
<div class="container-fluid">
	<div class="row">
			
		<div class="col-sm-3 col-md-2 sidebar">
		<%@ include file = "/layout/left.jsp" %>
		</div>
		
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form action="${cp }BoardMenuInsert" method="post" >
					 게시판 이름 &nbsp &nbsp :
					<input type ="text" name="board_name" value="">
					<select name="board_delete">
						<option>사용</option>
						<option>미사용</option>
					</select>
				<input type="submit" value ="생성">
				</form>
				<hr>
				
				<c:forEach items="${menuListUpdate }" var = "menu">
				
				<form action="${cp }BoardMenuUpdate" method="post" >
				게시판 이름 &nbsp &nbsp :
				<input type = "hidden" name =  "boardmenu_seq" value = "${menu.boardmenu_seq }">
				<input type = "text" name = "board_name" value = "${menu.board_name }">
				
				<c:choose>
					<c:when test="${menu.board_delete == 'Y' }">
					<select name="board_delete">
							<option>사용</option>
							<option selected="selected">미사용</option>
					</select>
					</c:when>
					<c:when test="${menu.board_delete == 'N' }">
					<select name="board_delete">
							<option selected="selected">사용</option>
							<option>미사용</option>
					</select>
					</c:when>
					<c:otherwise>오류발생..</c:otherwise>
				</c:choose>
				<input type="submit" value = "수정" >
				</form>
				</c:forEach>	
		</div>
	</div>
</div>
</body>
</html>