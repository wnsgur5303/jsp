<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%-- 개인정보를 전송 하므로  url에 노출되지 않도록 request body 영역에 파라미터를 전송 ==> method=post"--%>
<form action="<%=request.getContextPath() %>/loginController" method="post">
user id:<input type="text" name = "userid" value="123"><br>
user id:<input type="text" name = "userid" value="456"><br>
password:<input type="password" name="pass" value="789"><br>
<input type="submit" value="전송">
</form>

</body>
</html>