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
				<th>글번호</th>
				<td id="idx">${idx}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td id="user_name">${board.user_name}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td id="subject">${board.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td id="content">${board.content}</td>
			</tr>
			<tr>
				<th colspan="2">
				
				<button onclick="location.href='update?idx=${idx}'">수정</button>
				<button onclick="backToList()">목록</button>
				</th>
			</tr>
		</table>
	
	
</body>
<script>


	function backToList() {
		location.href='./';
	}
</script>
</html>