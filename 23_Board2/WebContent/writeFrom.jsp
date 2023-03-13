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
	<form action="write" method="post">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="user_name"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<button>작성</button>
					<button type="button" onclick="back()" >취소</button>
				</th>
			</tr>

		</table>
	
	
	</form>
</body>
<script>
	function back(){
		location.href='./';
		
	}
	
</script>
</html>