<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO 수정</title>
<link type="text/css" rel="stylesheet" href="resources/popup.css">
<script type="text/javascript">
	function edit_click() {
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
<h3>TODO 수정</h3>
<form action="edit" method="POST" onSubmit="return edit_click()">
			<input type="text" name="id" class="id" style="display: none" value="${list.id }">
			<div class="content">
			<label>제목을 입력하세요 : </label> <input type="text" name="title" value="${list.title }" maxlength="100"/> <br>
			<label>내용을 입력하세요 : </label> <input type="text" name="content" value="${list.content }" maxlength="255"/><br>
			<label>우선순위를 선택하세요 :</label>
			<div class="seq" id="${list.sequence }">
			<input type="radio" name="sequence" value="1" /> <label for="1">1순위</label>
			<input type="radio" name="sequence" value="2" /> <label for="2">2순위</label>
			<input type="radio" name="sequence" value="3" /> <label for="3">3순위</label>
			</div> <br>
			<label>마감기한을 선택하세요 : </label> <input type="date" name="deadline" id="datePicker" value="${list.deadline }"/>
			</div>
			<div class="footer">
			<input type="submit" class="btn" value="수정">
			<input type="reset" class="btn" value="원래대로">
			</div>
</form>

<script type="text/javascript">
	var seq = document.getElementsByClassName('seq')[0].id;
	var radio = document.getElementsByName('sequence');
	
	for (var i = 0; i < radio.length; i++) {
		if (radio[i].value == seq) {
			radio[i].checked = true; 
		}
	}
</script>
</body>
</html>