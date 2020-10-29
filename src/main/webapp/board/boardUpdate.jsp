<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<%@ include file = "/layout/commonLib.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(document).ready(function(){
	var count = 0
	var countdel= 0
	$('#summernote').summernote({
		height: 300
		
	});

	$('#filebutton').on('click', function(){
		var a = $('.filedelete').length
		
		if(a+count>=5){
			alert("5개이상 올릴수 없습니다.")
			return;
		}
		count++
		$('#frm').append("<input type='file' name='FILE_NAME"+count+"'>")
		$('#count').val(count)
	})
	

	$(".filedelete").on("click", function() {
		a = $(this).val();
		countdel++
// 		삭제의 시퀀스 값을 주기 위해서 이름을 다다르게 하고 value값도 다 다르게 하기 위함의 append 
		$('#frm').append("<input type='hidden' name='file_delete"+countdel+"' value='"+a+"'>")
		
// 		countdel을 통해서 내가 updateServlet을 갈때 for문의 개수를 정해주기 위한 역할

		$('#countdel').val(countdel)
		$(this).parent().remove();
		
	})
})
</script>

</head>
<style>
	img{
		width : 200px;
		height : 180px;
	}
</style>

<body>
	<%@ include file = "/layout/header.jsp" %>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file = "/layout/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form id="frm" class="form-horizontal" role="form"
						action="${cp }BoardUpdate" method="post"
						enctype=  "multipart/form-data">
					<input type = "hidden" name= "board_seq" value="${BoardVo.board_seq }">
					<div class="form-group">
						<label for="boardTitle" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="board_title" name="board_title"
							 placeholder="제목을 입력해주세요" value = "${BoardVo.board_title }" >
						</div>
					</div>

					<div class="form-group">
						<label for="board_content" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<textarea id="summernote" name="board_content" >${BoardVo.board_content }</textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="file" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
						
							<c:forEach items="${fileList }" var="fileList">
							<div id="${fileList.file_seq }">
							${fileList.file_realname }
								<button class="filedelete" type="button" class="btn btn-default"
									value="${fileList.file_seq }">삭제
								</button>
							</div>
							</c:forEach>
							
					<button type="button" id = "filebutton">파일 추가하기</button>
					<input id="count" name="count" type="hidden" value="0">
					<input id="countdel" name="countdel" type="hidden" value="0">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">게시글 수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
