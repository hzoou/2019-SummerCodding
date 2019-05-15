<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="edit" method="POST">
			<input type="text" name="id" value="${list.id }">
			<input type="text" name="title" value="${list.title }" maxlength="24">
			<input type="text" name="content" value="${list.content }" maxlength="7">
			<br><b>우선순위를 선택하세요</b>
			<div class="seq">
			<input type="radio" name="sequence" checked="checked" value="1" /> <label for="1">1순위</label>
			<input type="radio" name="sequence" value="2" /> <label for="2">2순위</label>
			<input type="radio" name="sequence" value="3" /> <label for="3">3순위</label>
			</div>
			<div class="btn">
			<input type="submit" value="등록">
			<input type="reset" value="내용지우기">
			</div>
</form>
</body>
</html>