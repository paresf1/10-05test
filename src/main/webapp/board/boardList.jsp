<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Jsp</title>

<%@ include file="/layout/commonLib.jsp"%>
<script>
	$(document).ready(function() {
		$("#memberList tr").on("click", function() {
			// data-userid		
			var board_seq = $(this).data("board_seq")
			document.location = "/Board/BoardContent?board_seq=" + board_seq;
		})
	})
</script>
<body>
	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


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
										<tr data-board_seq="${list.board_seq }">
											<%-- 							<input type="hidden" value = "${member.userid }"/> --%>
											<td>${list.board_seq }</td>
											<td>${list.board_title }</td>
											<td>${list.user_id }</td>
											<td><fmt:formatDate value="${list.create_date }"
													pattern="YYYY-MM-dd" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>


						<a href="${cp }BoardCreate?boardmenu_seq=${boardmenu_seq }" class="btn btn-default pull-right">사용자
							등록</a>
						<div class="text-center">
							<ul class="pagination">
								<c:forEach begin="1" end="${pages }" var="i">
									<c:choose>
										<c:when test="${i == page }">
											<li class="active"><span>${i }</span></li>
										</c:when>
										<c:otherwise>
											<!-- 							밑에 페이지 개수를 나타내는 li -->
											<li><a
												href="${pageContext.request.contextPath }/BoardList?page=${i}&boardmenu_seq=${boardmenu_seq }">${i }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
