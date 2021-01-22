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

		$("#abtn").on("click",function(){
			
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
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사원</h2>
		<div class="table-responsive">
			<form id = "frm" class="form-horizontal" role="form" action="${cp}/empModify" method="post">
				<input type="hidden" name ="empno" value="<%=vo.getEmpno() %>"/>
				
					<div class="form-group">
						<label for="empno" class="col-sm-2 control-label">사원번호</label>
						<div class="col-sm-10">
							<label class="control-label"><%=vo.getEmpno() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="eName" class="col-sm-2 control-label">사원이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="ename" name="ename"
								placeholder="사원이름" value="<%=vo.getEname()%>">
						</div>
					</div>
					
					<div class="form-group">
						<label for="job" class="col-sm-2 control-label">담당역활</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="job" name="job"
								placeholder="담당역활" value="<%=vo.getJob()%>">
						</div>
					</div>
					
					<div class="form-group">
						<label for="mgr" class="col-sm-2 control-label">매니저사번</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mgr" name="mgr"
								placeholder="매니저사번" value="<%=vo.getMgr()%>">
						</div>
					</div>
					
					<div class="form-group">
						<label for="sal" class="col-sm-2 control-label">급여</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="sal" name="sal"
								placeholder="급여" value="<%=vo.getSal()%>">
						</div>
					</div>
					
					<div class="form-group">
						<label for="comm" class="col-sm-2 control-label">성과급</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="comm" name="comm"
								placeholder="성과급" value="<%=vo.getComm()%>">
						</div>
					</div>
					
					<div class="form-group">
						<label for="deptNo" class="col-sm-2 control-label">소속부서번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="deptno" name="deptno"
								placeholder="소속부서번호" value="<%=vo.getDeptno()%>">
						</div>
					</div>

					<a class="btn btn-default pull-right" id ="abtn">수정완료</a>							
				</form>

		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>