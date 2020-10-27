<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Signin Template for Bootstrap</title>

	
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
	<script>
<%-- 	<% Cookie[] cookies= request.getCookies();%>		 --%>
		function getCookieValue(cookieName){
			cookies = document.cookie.split("; ")//이름, 벨류로 나뉘어짐
			names = "";
			values = ""; 
			for(i = 0 ; i < cookies.length; i++){
				names = cookies[i].split("=");// 이름과 벨류 두개로만 나뉘어짐
				if(names[0]==(cookieName)){
					values = names[1];
					}
			}
			return values
				
		}

		function setCookie(cookiName, cookieValue, expires){

// 			"USERNM = brown; path =/; expires=Wed, 07 Oct 2020 00:38:35 GMT;"
			
			var today = new Date();
			// 현재날짜에서 밀래로 + expires 만큼 한 날짜 구하기
			today.setDate(today.getDate() + expires );
			
			document.cookie = cookiName + "=" + cookieValue + "; path =/; expires=" + today.toGMTString();

			console.log(document.cookie); 
						
		}

		//해당쿠키의 expires속성을 과거날짜로 변경
		function deleteCookie(cookieName){
			setCookie(cookieName, "", -1);			
		}

		$(function(){
			// sign in 버튼이 클릭 되었을 떄 이벤트 핸들러
			
			// 수업시간에 한거
			$('button[type=button]').on('click', function(){

				if($('input[type=checkbox]').prop('checked')== true){
					Cookies.set('REMEMBER', 'Y')
					var value = $('#inputEmail').val()
					Cookies.set('USERNAME', value)
											
				}else{
					Cookies.remove('REMEMBER')
					Cookies.remove('USERNAME')
				}
				
				$("form").submit();
				
				//내가 한거				
// 				if($('input[type=checkbox]').attr('checked')== null){
// 					Cookies.remove('REMEMBER')
// 					Cookies.remove('USERNAME')
// 				}else{
// 				Cookies.set('REMEMBER', 'Y')
				
// 				var value = $('#inputEmail').val()
// 				Cookies.set('USERNAME', a)
// 			}		

		})
		
		
			//remember me cookie 확인
			if(Cookies.get("REMEMBER")=="Y"){
// 				$('input[name=check]').attr('checked',true)
				$('input[type=checkbox]').attr('checked',true)
				
				
// 				$('input[name=check]').prop('checked',true)
// 				$('input[name=check]').prop('checked',false)
// 				$('#inputEmail').attr('value', getCookieValue('USERNAME'))
				$('#inputEmail').val(Cookies.get("USERNAME"))
				
			}
		})
		
	</script>

    <title>Signin Template for Bootstrap</title>

	
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type = "text/javascript" src="${pageContext.request.contextPath }/js/js.cookie-2.2.1.min.js"></script>
  </head>

  <body>
  
				

	
    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath }/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name = "user_id" class="form-control" placeholder="Email address" required autofocus value = "lss">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="user_pass" class="form-control" placeholder="Password" required value = "lss">
        <div class="checkbox">
          <label>
            <input name = "check" type="checkbox" value="remember-me"  > Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> 		


  </body>
</html>
