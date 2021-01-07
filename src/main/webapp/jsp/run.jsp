<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(1==1){//임의로 에러 발생시키기 if(1=1)같은거 안하면 컴파일 부터 문제가 생겨서 500번 에러
throw new RuntimeException();
}
%>
</body>
</html>