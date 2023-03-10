<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Servlet Project</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<style>
	table, th, td{
		border : 1px solid black;
		border-collapse : collapse;
		padding : 5px 10px;
	}
	
	button{
		margin : 5px;
	}
	
	table {
		width : 500px;
	}
	
	input[type="text"]{
		width : 100%;
	}
	
	textarea {
		width : 100%;
		height : 150%;
		resize:none;
	}
	
</style>
</head>
<body>
	
		<table>
			<colgroup>
			<col width = "30%"/>
			<col width = "70%"/>
			</colgroup>
			<tr>
				<th>작성자</th>
				<td>${board.user_name}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${board.content}</td>
			</tr>
			<tr>
				<th colspan="2"><a href="./">리스트로 돌아가기</a></th>
			</tr>
		</table>
	
	
</body>
<script>

</script>
</html>