<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- application 영역에 저장된 requestCountMap 객체를 forEach를 통해 tr 태그로 생성 
	url 반복횟수
	--%>
	<table>
		<tr>
			<th>uri</th>
			<th>반복횟수</th>
		</tr>
		<c:forEach items="${requestCountMap}" var="entry">
		<tr>
			<th>${entry.key}</th>
			<th>${entry.value}</th>
		</tr>
		</c:forEach>
	</table>

</body>
</html>