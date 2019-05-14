<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="POST">
			<input type="text" name="title" id="title" placeholder="제목" maxlength="24">
			<input type="text" name="content" id="contenct" placeholder="내용" maxlength="7">
			<br><b>우선순위를 선택하세요</b>
			<div class="seq">
			<input type="radio" name="sequence" checked="checked" id="1" value="1" /> <label for="1">1순위</label>
			<input type="radio" name="sequence" id="2" value="2" /> <label for="2">2순위</label>
			<input type="radio" name="sequence" id="3" value="3" /> <label for="3">3순위</label>
			</div>
			
			<div class="btn">
			<input type="submit" value="등록">
			<input type="reset" value="내용지우기">
			</div>
		</form>
</body>
</html>