<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here123</title>
    <%@include file="/common/common_lib.jsp"%>
    <!--common_lib.jsp 의 내용을 지금 기술되는 부분에 코드를 복사해서 붙여넣기 -->
	<link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="<%=request.getContextPath() %>/loginController" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputid" class="sr-only">userid</label>
        <input type="text" id="inputEmail" class="form-control" 
        placeholder="사용자 아이디" required autofocus name = "userid" value="brown">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="" name="pass" value="brownpass">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

</body>
</html>