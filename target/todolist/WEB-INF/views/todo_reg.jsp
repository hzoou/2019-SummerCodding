<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO 등록</title>
<link type="text/css" rel="stylesheet" href="resources/popup.css">
<script type="text/javascript">
	//등록 시 제목, 내용 빈 값 확인
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
	
	//등록 시 제목, 내용 글자수 제한
	function length_check(obj, maxlength) {
		var str = obj.value;
		var str_length = str.length;
		var max_length = maxlength;
		var change_str = "";
		
		if (str_length > max_length) {
			alert('글자수는 최대 ' + max_length + '까지 가능합니다. \n초과된 내용은 자동으로 삭제됩니다.');
			change_str = str.substring(0, max_length);
			obj.value = change_str;
		}
		
		obj.focus();
	}
</script>
</head>
<body>
	<h3>TODO 등록</h3>
	<form action="register" method="POST" onSubmit="return reg_click()">
			<ul class="content">
				<li>
					<label style="color: #c00">*&nbsp;</label><label>제목을 입력하세요 : </label> <input type="text" name="title" placeholder="ex) 서머코딩 2차 과제" onkeyup="length_check(this, 100);"/>
				</li>
				<li>
					<label style="color: #c00">*&nbsp;</label><label>내용을 입력하세요 : </label> <textarea id="content" name="content" placeholder="ex) 새로운 TODO 등록 구현" onkeyup="length_check(this, 255);"></textarea>
				</li>
				<li>
					<label style="color: #c00">*&nbsp;</label><label>우선순위를 선택하세요 :</label>
					<div class="seq">
						<input type="radio" name="sequence" checked="checked" value="1"> <label for="1">1순위</label>
						<input type="radio" name="sequence" value="2" /> <label for="2">2순위</label>
						<input type="radio" name="sequence" value="3" /> <label for="3">3순위</label>
					</div>
				</li>
				<li>
					<label style="visibility: hidden;">*&nbsp;</label><label>마감기한을 선택하세요 : </label> <input type="date" name="deadline" id="datePicker"/>
				</li>
			</ul>
			<div class="footer">
				<input type="submit" class="btn" value="등록" /> <input type="reset" class="btn" value="내용지우기" />
			</div>
	</form>
</body>
</html>