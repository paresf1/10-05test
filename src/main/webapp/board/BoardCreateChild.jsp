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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- include summernote css/js -->
<style>
	#aa{
		width : 80%;
		height : 80%;
		float: left;
		padding-left: 19%;
		padding-top: 50px;
	}
	#title{
		width : 80%;
		margin-bottom: 10px;
		
	}
	#regBtn2{
		width : auto;
		padding-left: 80%;
	}
	#filebutton{
		margin-left : 1%;
	}
</style>
<script>
$(document).ready(function() {
	var count = 0;
	$('#summernote').summernote({
		height: 300
		
	});
	
	$("#regBtn").on("click", function(){	
		$("#frm").submit()
	})
	
	$('#filebutton').on('click', function(){
		if(count>=5){
			alert("5개이상 올릴수 없습니다.")
			return;
		}
		count++
		$('#frm').append("<input type='file' name='FILE_NAME"+count+"'>")
		$('#count').val(count)
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
			
				<div id="aa">
			<form id="frm" class="form-horizontal" role="form"
						action="${cp }BoardCreateChild" method="Post"
						enctype=  "multipart/form-data">
				<input id="title" name="board_title" placeholder="제목을 입력해주세요">
				
				<textarea id="summernote" name="board_content"></textarea>
				<button type="button" id = "filebutton">파일 추가하기</button>
				<input id="count" name="count" type="hidden" value="0">
				<br>
				<div class="form-group" id = "regBtn2">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="regBtn" type="button" class="btn btn-default">답글 등록</button>
					</div>
				</div>
				
			</form>
			</div>
		</div>
	</div>
</body>
</html>