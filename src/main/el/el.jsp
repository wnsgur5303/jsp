<%@page import="kr.or.ddit.user.model.UserVo"%>
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
		//컨트롤러에서 조회한 데이터를 request에 저장 한다라는 가정
		UserVo userVo = new UserVo();
		userVo.setUserid("brown");
		userVo.setUsernm("브라운");
		userVo.setAlias("곰");
		
		request.setAttribute("userVo", userVo);
	%>
	
	<!-- view -->
	<h3>표현식 - userVo</h3>
	userVo : <%=request.getAttribute("userVo") %><br>
	userVo.getUserid() : <%= ((UserVo)request.getAttribute("userVo")).getUserid() %><br>

	<h3>el - userVo</h3>
	userVo : ${usrVo}<br>
	userVo.getUserid() : ${userVo.userid} / ${userVo.getUserid()} <br>
</body>
</html>