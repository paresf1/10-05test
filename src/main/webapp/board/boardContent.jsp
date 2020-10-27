<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			document.location = "/BoardContent?board_seq=" + board_seq;
		})
	})
	
function fnChkByte(obj, maxByte){
    var str = obj.value;
    var str_len = str.length;
    var rbyte = 0;
    var rlen = 0;
    var one_char = "";
    var str2 = "";

    for(var i=0; i<str_len; i++){
        one_char = str.charAt(i);
        if(escape(one_char).length > 4)
            rbyte += 2;                                         //한글2Byte
        else
            rbyte++;                                            //영문 등 나머지 1Byte
        if(rbyte <= maxByte)
            rlen = i+1;                                          //return할 문자열 갯수
     if(rbyte > maxByte){
  		// alert("한글 "+(maxByte/2)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
  		alert("메세지는 최대 " + maxByte + "byte를 초과할 수 없습니다.")
  		str2 = str.substr(0,rlen);                                  //문자열 자르기
  		obj.value = str2;
  		fnChkByte(obj, maxByte);
     	}else{
        document.getElementById('byteInfo').innerText = rbyte;
     	}
	}	
	}
</script>

<style>
	#reply{
		width : 90%;
		height : 80%;
		float: left;
		padding-left: 19%;
		padding-top: 50px;
	}	
	#write{
		width : 60%;
		height : 80%;
	}
	#writediv{
		padding-left: 4%;
	}
	#submit{
		width : auto;
		
	}
	#submitright{
		padding-left: 53%;
	}
</style>
<body>
	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label" >${boardContent.board_title }</label>
						</div>
					</div>
					<br>
					<br>
					<br>
				<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<label class="control-label" >${boardContent.board_content }</label>
						</div>
					</div>
					<br>
					<br>
					<br>
				<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
<%-- 							<label class="control-label" >${boardContent.board_content }</label> --%>
						</div>
				</div>
					<br>
					<br>
					<br>
				</div>
				
				
				<div class="form-group" id = "reply">
						<label for="userNm" class="col-sm-2 control-label">댓글</label>
						<c:forEach items = "${replyList }" var = "reply">
						<label for="userNm" class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<label class="control-label" >${reply.reply_content }&nbsp;&nbsp; /&nbsp;&nbsp;</label>
							<label class="control-label" >${reply.user_id }&nbsp;&nbsp; /&nbsp;&nbsp;</label>
							<label class="control-label" >${reply.create_date } &nbsp;&nbsp;</label>
						</div>
						</c:forEach>
			</div>
			
			
			<form class="form-horizontal" role="form"
						action="${cp }ReplyCreate" method="Post">
			<div class="form-group">
				<label for="reply"  class="col-sm-2 control-label">댓글</label>
				<div class="col-sm-10" id = "writediv">
					<input type= "hidden" name = "board_seq" value = "${boardContent.board_seq }">
					<textarea id="write" class="form-control"  
					 onKeyUp="javascript:fnChkByte(this,'500')"
					name="reply_content" rows="10" cols="20" 
					placeholder="댓글을 입력해주세요"></textarea>
					<span id="byteInfo">0</span> 500bytes
					<div id = "submitright">
					<input id="submit" class="form-control" type="submit" value = "댓글 등록">
					</div>
				</div>
			</div>
			</form>
			
			
		</div>
	</div>
</body>
</html>
