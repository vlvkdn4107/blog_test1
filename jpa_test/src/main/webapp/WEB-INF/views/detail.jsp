<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "layout/header.jsp" %>
<main class = "container">
	<a class = "btn btn-warning" href="#">수정</a>
	<button type="button" class = "btn btn-danger">삭제</button>
	<br/>
	<br/>
	<h5 class = "m-2">조회수 : <i>${board.readCount}</i></h5>
	<br/>
	<br/>
	<h3 class = "m-2">${board.title}</h3>
	<hr/>
	
	<div class ="form-group">
		<div class = "m-2">${board.content}</div>
	</div>
	<hr/>
</main>

 <%@ include file = "layout/footer.jsp" %>