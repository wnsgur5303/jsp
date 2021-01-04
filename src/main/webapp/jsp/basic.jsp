<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@ %> : 지시자-jsp 페이지에 대한 설정 정보--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Date date = new Date();%> <%-- 스크립플릿:자바코드를 작성 --%>
Hello, World <%=new Date()%><%-- 표현식 : 문자열 출력 --%>
asd
</body>
</html>

<%-- jsp 구성요소
	1.지시자 : page의 설정 정보
	2.스크릿플릿 : java코드 ==> JSTL(Java Standard Tag Library)
	3.표현식 : 문자열로 출력 ==> EL(Expression languager,표현언어)
	4.주석
	5.선언부:변수나 메소드 선언 , jsp는 화면 컨텐츠를 생성하는 역활 
	변수나 메소드는 로직 처리시 주로 사용
	
	
1. jsp는 servlet 으로 변환되어 서비스 된다
2.servlet<-container(tomcat)이 jsp를 서블릿으로 변환하는 과정에서
	사용되는 폴더는 work 폴더
	-tomcat 도 개발자가 만든 프로그램으로 비정상적으로 동작할 때가 있음
	-개발자가 jsp 파일을 수정하였음에도 수정 내역이 반영되지 않을 경우
	work폴더에 생성된 jsp 변환 파일을 (java,class)를 삭제해주면 새롭게 만들어 준다.
3.jsp를 서블릿으로 변환하는 시기는 해당 jsp에 대해 최초 요청이 일어 났을 경우에 변환
	-서블릿으로 생성이 된 이후 같은 파일에 대한 요청은 이미 변환된 파일로 서비스


지시자*  이거 없는상태로 개발하는것은 불가능
스플릿플릿 java 코드 기술 -< JSTL   나중가면 안씀
표현식: 출력-->  EL
주석
선언부 : 변수,메소드 선언->View와는 크게 관련이 없는 부분
--%>



