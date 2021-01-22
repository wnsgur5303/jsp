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

<link href="${cp}/css/bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<script src="/js/bootstrap.js"></script><!-- Custom styles for this template -->
    	<%@include file="/common/common_lib.jsp"%>
		<link href="${cp}/css/dashboard.css" rel="stylesheet">
		<link href="${cp}/css/blog.css" rel="stylesheet">
		
</head>
<script type="text/javascript">
//문서 로딩이 완료되고 나서 실행되는 영역
	$(function(){
		
		$("#modifyBtn").on('click',function(){
			$("#frm").attr("method","get");
			$("#frm").attr("action","${cp}/empModify");
			$("#frm").submit();
		});
		
		$("#deleteBtn").on('click',function(){
			$("#frm").attr("method","post");
			$("#frm").attr("action","${cp}/deleteUser");
			$("#frm").submit();
		});
		
	});
	</script>
<body>

	
<%@include file = "/common/header.jsp"%>

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@include file="/common/left.jsp"%>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
<%EmpVo vo = (EmpVo)request.getAttribute("empInfo"); %>
<form id = "frm">
<input type="hidden" id="empno" name = "empno" value="<%=vo.getEmpno() %>"/>
</form>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사원</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사번</th>
					<th><%=vo.getEmpno() %></th>
				</tr>
				<tr>
					<th>사원이름</th>
					<th><%=vo.getEname() %></th>
				</tr>
				<tr>
					<th>담당역활</th>
					<th><%=vo.getJob() %></th>
				</tr>
				<tr>
					<th>매니저사번</th>
					<th><%=vo.getMgr() %></th>
				</tr>
				<tr>
					<th>입사일자</th>
					<th><%=vo.getHiredate_fmt() %></th>
				</tr>
				<tr>
					<th>급여</th>
					<th><%=vo.getSal() %></th>
				</tr>
				<tr>
					<th>성과급</th>
					<th><%=vo.getComm() %></th>
				</tr>
				<tr>
					<th>소속부서번호</th>
					<th><%=vo.getEmpno() %></th>
				</tr>
			</table>
		</div>
<div class="form-group"></div>
		<button type ="button" id = "modifyBtn" class="btn btn-default pull-right">사용자 수정</button>
		<button type ="button" id = "deleteBtn" class="btn btn-default pull-right">사용자 삭제</button>
</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>