<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
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
	<%@include file="/common/common_lib.jsp"%>
<%-- 	<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
	<script src="/js/bootstrap.js"></script> --%>
	<link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/blog.css" rel="stylesheet">
		
		
		
		
<script type="text/javascript">
//문서 로딩이 완료되고 나서 실행되는 영역
	$(function(){
		
		$("#modifyBtn").on('click',function(){
			$("#frm").attr("method","get");
			$("#frm").attr("action","<%=request.getContextPath()%>/userModify");
			$("#frm").submit();
		});
		
		$("#deleteBtn").on('click',function(){
			$("#frm").attr("method","post");
			$("#frm").attr("action","<%=request.getContextPath()%>/deleteUser");
			$("#frm").submit();
		});
		
	});
</script>		
</head>

<body>

<%@include file = "/common/header.jsp"%>

<%UserVo user = (UserVo)request.getAttribute("user");%>

<form id = "frm">
<input type="hidden" id="userid" name = "userid" value="<%=user.getUserid() %>"/>
</form>

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@include file="/common/left.jsp"%>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			
			<form class="form-horizontal" role="form">	
			
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
						<img src="<%=request.getContextPath() %>/profile/<%=user.getUserid() %>.png">
						</div>
					</div>
			
			
				<input type="hidden" name ="userid" value="<%=user.getUserid() %>"/>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getUserid() %></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getUsernm()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getPass()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">등록일시</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getReg_dt_fmt()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getAlias()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">도로주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getAddr1()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getAddr2()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호 코드</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getZipcode()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">업로드파일명</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getRealfilename()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">실제파일경로</label>
						<div class="col-sm-10">
							<label class="control-label"><%=user.getRealfilename()%></label>
						</div>
					</div>							
				</form>

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