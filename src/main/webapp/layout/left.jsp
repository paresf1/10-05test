<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<% request.getAttribute("menuList"); %>

	<div>
	<ul class="nav nav-sidebar">
			<li class="active"><a href="${pageContext.request.contextPath }/main.jsp">Main <span class="sr-only">(current)</span></a></li>
			<li class="active"><a href="${pageContext.request.contextPath }/BoardMenuInsert">게시글생성</a></li>
			
			<c:forEach items="${menuList }" var = "menu" >
				<li class="active"><a href="${pageContext.request.contextPath }/BoardList?boardmenu_seq=${menu.boardmenu_seq}">${menu.board_name }</a></li>
			</c:forEach>
			
	</ul>
	</div>