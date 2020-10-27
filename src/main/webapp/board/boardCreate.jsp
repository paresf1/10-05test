<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/layout/commonLib.jsp" %>
<!-- include libraries(jQuery, bootstrap) -->

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- include summernote css/js -->
<style>
	#aa{
		width : 90%;
		height : 80%;
		float: left;
		padding-left: 19%;
		padding-top: 50px;
	}
	#title{
		width : 80%;
		padding-left: 20px;
	}
	#regBtn2{
		width : auto;
		padding-left: 80%;
	}
</style>
<script>
$(document).ready(function() {
	$('#summernote').summernote({
		height: 300
		
	});
	
	$("#regBtn").on("click", function(){	
		$("#frm").submit()
	})
});
</script>
</head>
<body>
<%@ include file = "/layout/header.jsp" %>

<div class="container-fluid">
<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
		<%@ include file = "/layout/left.jsp" %>
		</div>
</div>
		<div id="aa">
			<form id="frm" class="form-horizontal" role="form"
						action="${cp }BoardCreate" method="Post"
						enctype=  "multipart/form-data">
				<input id="title" name=board_title placeholder="제목을 입력해주세요">
				<textarea id="summernote" name="board_content"></textarea>
				<div class="form-group">
					<label for="filename" class="col-sm-1 control-label">파일</label>	
					<div class="col-sm-10">
						<input type="file" name="FILE_NAME">
					</div>
					<br>
					<br>
					<label for="filename" class="col-sm-1 control-label">파일</label>	
					<div class="col-sm-10">
						<input type="file" name="FILE_NAME">
					</div>
					<br>
					<br>
					<label for="filename" class="col-sm-1 control-label">파일</label>	
					<div class="col-sm-10">
						<input type="file" name="FILE_NAME">
					</div>
					<br>
					<br>
					<label for="filename" class="col-sm-1 control-label">파일</label>	
					<div class="col-sm-10">
						<input type="file" name="FILE_NAME">
					</div>
					<br>
					<br>
					<label for="filename" class="col-sm-1 control-label">파일</label>	
					<div class="col-sm-10">
						<input type="file" name="FILE_NAME">
					</div>
				</div>
				<div class="form-group" id = "regBtn2">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="regBtn" type="button" class="btn btn-default">사용자 등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>