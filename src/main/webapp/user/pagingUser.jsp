<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%@include file="/common/common_lib.jsp"%>
<%-- 	<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
	<script src="/js/bootstrap.js"></script> --%>
	<link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/blog.css" rel="stylesheet">
		
		
		
		
<script type="text/javascript">
//문서 로딩이 완료되고 나서 실행되는 영역
	$(function(){
		
		$(".user").on("click",function(){
			
			//this : 클릭 이베트가 발생한 element
			//data-userId ==> data-userid, 속성명은 대소분자 무시하고 소분자로 인식
			var userid = $(this).data("userid");
			$("#userid").val(userid);
			$("#frm").submit();
		});
		
	});
</script>		
</head>

<body>
<form id ="frm" action="<%=request.getContextPath() %>/user">
	<input type="hidden" id="userid" name = "userid" value=""/>
</form>
	
<%@include file = "/common/header.jsp"%>

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@include file="/common/left.jsp"%>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
<%List<UserVo> list = (List<UserVo>)request.getAttribute("userList"); %>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				<%
				for(UserVo vo : list){ 
				%>
				<tr class ="user" data-userid="<%=vo.getUserid() %>">
					<td><%=vo.getUserid() %></td>
					<td><%=vo.getUsernm() %></td>
					<td><%=vo.getAlias() %></td>
					<td><%=vo.getReg_dt_fmt() %></td>
				</tr>
				<% }%>

			</table>
		</div>

		<a class="btn btn-default pull-right" href="../user/registUser.jsp">사용자 등록</a>
	
		<div class="text-center">
			<ul class="pagination">
			
			
			<!-- pagination 값이 4이므로 1부터 4까지 4번 반복된다.
				햔재 사용자수	: 16명
				페이지 사이즈	: 5
				전체 페이지 수	: 4페이지 -->
				<li class="prev">
				<a href="${pageContext.request.contextPath}/pagingUser?page=1&pageSize=${pageVo.getPageSize}">«</a>
				</li>
				<c:set var = "cnt" value="${allpage}"/>
				<c:ForEach begin ="1" end="${allpage}" var="i">
					<c:choose>
						<c:when test ="${pageVo.page == i}">
						<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/pagingUser?page=${i}&pageSize=${pageVo.pageSize}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:ForEach>
			<li class="next">
				<a href="${pageContext.request.contextPath}/pagingUser?page=${cnt}&pageSize=${pageVo.getPageSize}">»</a>
			</li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>