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
	
</style>
</head>
<body>
	<button onclick="location.href='writeFrom.jsp'">글쓰기</button>
	<table>
		<colgroup>
			<col width = "10%"/>
			<col width = "50%"/>
			<col width = "20%"/>
			<col width = "20%"/>
		</colgroup>
		
		<thead>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>작성자</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${list.size() == 0}">
				<tr>
					<th colspan="4">작성된 글이 존재하지 않습니다. </th>
				</tr>
			</c:if>
			<!-- EL TAG에서는 객체 내 private 필드를 getter()를 사용하지 않고 꺼내올 수 있다.
				물론 getter()메서드로 접근 가능하도록 되어있어야만 가능하다.
			 -->
			<c:if test="${list.size() > 0}">
				<c:forEach items="${list}" var="board" varStatus="stat">
					<tr>
						<td>${stat.index+1}</td>
						<td><a href="detail?idx=${stat.index}">${board.subject}</a></td>
						<td>${board.user_name}</td>
						<td><a href="remove?idx=${stat.index}">삭제</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</thead>
	</tbody>
</body>
<script>

</script>
</html>