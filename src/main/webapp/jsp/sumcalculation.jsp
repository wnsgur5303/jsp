<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/sumCalculation" method="post">
<input type="text" name ="start" value="1">
<input type="text" name ="end" value="10">
<input type="submit" value="실행">
</form>

</body>
</html>