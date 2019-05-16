<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO 등록</title>
<link type="text/css" rel="stylesheet" href="resources/popup.css">
<script type="text/javascript">
	function reg_click() {
		var title = document.getElementsByName('title');
		var content = document.getElementsByName('content');

		if (title[0].value.trim() == "") {
			alert('제목을 입력하세요!');
			title[0].focus();
			return false;
		} else if (content[0].value.trim() == "") {
			alert('내용을 입력하세요!');
			content[0].focus(); 
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
<h3>TODO 등록</h3>
<form action="register" method="POST" onSubmit="return reg_click()">
			<div class="content"><br>
			&nbsp;<label>제목을 입력하세요 : </label> <input type="text" name="title" placeholder="ex) 서머코딩 2차과제" maxlength="100"> <br>
			<label>내용을 입력하세요 : </label> <input type="text" name="content" placeholder="ex) 새로운 TODO 등록 구현" maxlength="255"><br>
			&nbsp;<label>우선순위를 선택하세요 :</label>
			<div class="seq">
			<input type="radio" name="sequence" checked="checked" value="1"> <label for="1">1순위</label>
			<input type="radio" name="sequence" value="2" /> <label for="2">2순위</label>
			<input type="radio" name="sequence" value="3" /> <label for="3">3순위</label>
			</div> <br>
			<label>마감기한을 선택하세요 : </label> <input type="date" name="deadline" id="datePicker"/>
			</div>
			<div class="footer">
			<input type="submit" class="btn" value="등록">
			<input type="reset" class="btn" value="내용지우기">
			</div>
</form>
</body>
</html>