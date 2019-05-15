<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO 등록</title>
<style>
* {
	background-color: #fff;
}
h3 {
	text-align: center;
}
input[type=text] {
	width: 215px;
}
.id {
	display: none;
}
label {
	font-size: 15px;
}
.content {
    margin-top: 40px;
	margin-left: 70px;
}
.seq {
	display: inline-block;
}
.footer {
    text-align: center;
    margin-top: 30px;
}
.btn {
	font-size: 13px;
    color: #c00;
    background-color: #fff;
    border: #c00 solid 1px;
    transition-duration: 0.4s;
    cursor: pointer;
}
.btn:hover {
	background-color: #c00;
  	color: #fff;
}
</style>
</head>
<body>
<h3>TODO 등록</h3>
<form action="register" method="POST">
			<div class="content">
			<label>제목을 입력하세요 : </label> <input type="text" name="title" placeholder="ex) 서머코딩 2차과제"/> <br>
			<label>내용을 입력하세요 : </label> <input type="text" name="content" placeholder="ex) 새로운 TODO 등록 구현" /><br>
			<label>우선순위를 선택하세요 :</label>
			<div class="seq">
			<input type="radio" name="sequence" checked="checked" value="1" /> <label for="1">1순위</label>
			<input type="radio" name="sequence" value="2" /> <label for="2">2순위</label>
			<input type="radio" name="sequence" value="3" /> <label for="3">3순위</label>
			</div>
			</div>
			<div class="footer">
			<input type="submit" class="btn" value="등록">
			<input type="reset" class="btn" value="내용지우기">
			</div>
</form>
</body>
</html>