<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td{border: 1px solid black;}
table{width : 100%; text-align:center}
</style>
</head>
<body>
<table border='1'>	
	<%for(int i = 2; i<10;i++) {
			out.write("<tr>");	
		for(int j = 1; j<10; j++) {
				out.write("<td>");
				out.write(i +" * "+j+ " = "+i*j);
				out.write("</td>");
		}
			out.write("</tr>");
	}%>
</table>
</body>
</html>