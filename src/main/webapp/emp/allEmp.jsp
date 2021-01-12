<%@page import="kr.or.ddit.emp.model.EmpVo"%>
<%@page import="java.util.List"%>
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

<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<script src="/js/bootstrap.js"></script><!-- Custom styles for this template -->
    	<%@include file="/common/common_lib.jsp"%>
		<link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
		<link href="<%=request.getContextPath() %>/css/blog.css" rel="stylesheet">
		
</head>

<body>

	
<%@include file = "/common/header.jsp"%>

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@include file="/common/left.jsp"%>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
<%List<EmpVo> list = (List<EmpVo>)request.getAttribute("empList"); %>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사원</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사번</th>
					<th>사원이름</th>
					<th>담당역활</th>
					<th>입사일자</th>
				</tr>
				<%for(EmpVo vo : list){ %>
				<tr>
					<td><a href="<%=request.getContextPath() %>/empInfo?empno=<%=vo.getEmpno() %>"><%=vo.getEmpno() %></a></td>
					<td><%=vo.getEname() %></td>
					<td><%=vo.getJob() %></td>
					<td><%=vo.getHiredate() %></td>
				</tr>
				<% }%>

			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>