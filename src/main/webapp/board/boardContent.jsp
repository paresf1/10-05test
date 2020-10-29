<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		
		$("#delete").on("click", function() {
			// data-userid		
			var board_seq = "${boardContent.board_seq }"
			document.location = "/Board/BoardDelete?board_seq=" + board_seq+"&boardmenu_seq=${boardContent.boardmenu_seq }" ;
		})
		
		$("#update").on("click", function() {
			// data-userid		
			var board_seq = "${boardContent.board_seq }"
			document.location = "/Board/BoardUpdate?board_seq=" + board_seq;
		})
		
		$(".fileDown").on("click", function(){
			var seq = $(this).val()
			document.location = "/Board/FileDownload?file_seq=" + seq;
		})

		$(".replydelete").on("click", function(){
			var replyseq = $(this).val()
			var boardseq = "${boardContent.board_seq }"
			document.location = "/Board/ReplyDelete?reply_seq="+ replyseq +"&board_seq=" + boardseq;
			$(this).parent().remove();
		})
		$("#childContent").on("click", function(){
			var board_seq = "${boardContent.board_seq }"
			document.location = "/Board/BoardCreateChild?board_seq="+board_seq+"&boardmenu_seq=${boardContent.boardmenu_seq }" ; 
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
		padding-left: 21%;
	}
	#submit{
		width : auto;
		
	}
	.submitright{
		padding-left: 53%;
	}
	#update{
		margin-left: 25%;
	}
	#childContent{
		margin-left: 40%;
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
						
						<c:forEach items="${fileList }" var ="fileList">
						<button class="fileDown" type="button" class="btn btn-default" value="${fileList.file_seq }">${fileList.file_realname } </button>
						</c:forEach>
						
						</div>
				</div>

				<br>
					<br>
					<br>
				</div>
				<div class="form-group" class ="update">
					<div class="col-sm-offset-2 col-sm-10">
					
						<c:choose>
							<c:when test="${boardContent.user_id == memberVo.user_id }">
								<button id="update" type="button" class="btn btn-default">게시글수정</button>
								<button id="delete" type="button" class="btn btn-default">게시글삭제</button>
								<style>	#childContent{margin-left: 0px}</style>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<button id="childContent" type="button" class="btn btn-default">답글작성</button>
						<br>
					</div>
				</div>
				<br>
				<br>
				<div class="form-group" id = "reply">
						<label for="userNm" class="col-sm-2 control-label">댓글</label>
						
						<c:forEach items = "${replyList }" var = "reply">
						<label for="userNm" class="col-sm-2 control-label"></label>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${reply.reply_delete == 'N' }">
								<label class="control-label" >${reply.reply_content }&nbsp;&nbsp; /&nbsp;&nbsp;</label>
								<label class="control-label" >${reply.user_id }&nbsp;&nbsp; /&nbsp;&nbsp;</label>
								<label class="control-label" ><fmt:formatDate value="${reply.create_date }" pattern="YYYY-MM-dd" />  &nbsp;&nbsp;</label>
								<button type="button" class = "replydelete" value ="${reply.reply_seq }">삭제</button>
								</c:when>
								<c:otherwise><label class="control-label" >삭제된 댓글입니다.</label></c:otherwise>
							</c:choose>
							
							<div id="${reply.reply_seq }">
							</div>
							
						</div>
						</c:forEach>
				</div>
			
			
			<form class="form-horizontal" role="form"
						action="${cp }ReplyCreate" method="Post">
			<div class="form-group">
				<div class="col-sm-10" id = "writediv">
					<input type= "hidden" name = "board_seq" value = "${boardContent.board_seq }">
					<textarea id="write" class="form-control"  
					 onKeyUp="javascript:fnChkByte(this,'500')"
					name="reply_content" rows="10" cols="20" 
					placeholder="댓글을 입력해주세요"></textarea>
					<span id="byteInfo">0</span> 500bytes
					<div class = "submitright">
					<input id="submit" class="form-control" type="submit" value = "댓글 등록">
					</div>
				</div>
			</div>
			</form>
			
			
		</div>
	</div>
</body>
</html>
