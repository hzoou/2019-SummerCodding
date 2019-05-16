<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO LIST</title>
<script type="text/javascript">
	opener.document.location.reload();
	self.close();

	function regBtn_click() {
		var reg = confirm('할일을 등록하시겠습니까?');
		if (reg) {
			var width = 520;
		    var height = 300;
		    var top = (screen.availHeight - height) / 2;
		    var left = (screen.availWidth - width) / 2;
		    var strFeature;
		    strFeature = 'height=' + height + ',width=' + width + ',menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=yes,top=' + top + ',left=' + left

			window.open("/todolist/reg_btn", "a", strFeature);
		} 
	}
	
	function editBtn_click() {
		var id = event.srcElement.id;
		var edit = confirm('항목을 수정하시겠습니까?');
		if (edit) {
			var url = "/todolist/edit_btn?id="+id;
			
			var width = 520;
		    var height = 300;
		    var top = (screen.availHeight - height) / 2;
		    var left = (screen.availWidth - width) / 2;
		    var strFeature;
		    strFeature = 'height=' + height + ',width=' + width + ',menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=yes,top=' + top + ',left=' + left

			window.open(url, "a", strFeature);
		} 
	}
	
	function removeBtn_click() {
		var id = event.srcElement.id;
		var remove = confirm('항목을 삭제하시겠습니까?');
		if (remove) {
			self.location.href = "/todolist/remove?id="+id;
		} 
	}
	
	
	function check_click() {
		var id = event.srcElement.id;
		var type = document.getElementById(id).value
		if (type == 'todo') {
			var complete = confirm('항목을 완료하셨습니까?');
			if (complete) {
				self.location.href = "/todolist/complete?id="+id;
			}
		} else {
			var cancel = confirm('항목에 대한 완료를 취소하시겠습니까?');
			if (cancel) {
				self.location.href = "/todolist/cancel?id="+id;
			}
		}
	}
	
</script>
<style>
* {
	background-color: #f2f2f2;
}

h1 {
	text-align: center;
}

.regBtn {
    width: 150px;
    height: 40px;
    font-size: 17px;
    font-weight: bold;
    color: #7b7b7b;
    background: #fff;
    border: #555 solid 1px;
    transition-duration: 0.4s;
    cursor: pointer;
}

.regBtn:hover {
	color: #fff;
	background: #7b7b7b;
}

a {
	color: #fff;
	background: inherit;
	display: block;
	text-decoration: none;
	font-size: 15px;
}

.list {
	width: 355px;
	float: left;
}

.checkbox {
	margin-left: 0px;
	cursor: pointer;
}

.btn {
    margin-right: 5px;
    font-size: 12px;
    color: #c00;
    background-color: #fff;
    border: #c00 solid 1px;
    transition-duration: 0.4s;
    cursor: pointer;
    float: right;
}

.btn:hover {
	background-color: #c00;
  	color: #fff;
}

.list_title {
	height: 65px;
	padding: 0px 0px 0px 20px;
	background: #c00;
	color: #fff;
	font-size: 23px;
	font-weight: bold;
	line-height: 65px;
	width: 302px;
	margin: 15px;
}

.list_content {
	background-color: #fff;
	margin: 15px;
	border: solid 1px #6d6d6d;
	width: 300px;
	height: 80px;
	padding: 10px;
}

.content_main {
	font-size: 18px;
	font-weight: bold;
	background: inherit;
	text-overflow: ellipsis;
	text-overflow: ellipsis;
	display: block;
	overflow: hidden;
	white-space: nowrap;
	display: block;
	overflow: hidden;
	white-space: nowrap;
}

.content_content {
	margin: 4px 0 0 0;
	font-size: 14px;
	background: inherit;
	color: #2b2b2b;
	text-overflow: ellipsis;
	display: block;
	overflow: hidden;
	white-space: nowrap;
}

.content_sub {
	font-size: 12px;
	background: inherit;
	color: #2b2b2b;
}
</style>
</head>
<body>
	<h1>MY TODO LIST</h1>
	
	<input type="button" class="regBtn" value="새로운 TODO 등록" onclick="regBtn_click();">

	<div class=list>
		<div class=list_title>TODO</div>
		<c:forEach items="${todoList }" var="todolist">
			<div class="list_content">
				<input type="checkbox" class="checkbox" value="todo" id="${todolist.id }" onclick="check_click();"><input type="button" class="btn" id="${todolist.id }" value="X" onclick="removeBtn_click();"><input type="button" class="btn" id="${todolist.id }" value="edit" onclick="editBtn_click();"><br> 
				<span class=content_main>${todolist.title }</span>
				<span class=content_content>${todolist.content }</span> 
				<span class=content_sub>우선순위:${todolist.sequence } 마감기한:${todolist.limitdate } </span>
			</div>
		</c:forEach>
	</div>

	<div class=list>
		<div class=list_title>DONE</div>
		<c:forEach items="${doneList }" var="donelist">
			<div class="list_content">
				<input type="checkbox" class="checkbox" value="done" id="${donelist.id }" checked="checked" onclick="check_click();"><input type="button" class="btn" id="${donelist.id }" value="X" onclick="removeBtn_click();"><input type="button" class="btn" id="${donelist.id }" value="edit" onclick="editBtn_click();"><br> 
				<span class=content_main>${donelist.title }</span>
				<span class=content_content>${donelist.content }</span> 
				<span class=content_sub>우선순위:${donelist.sequence } 마감기한:${donelist.limitdate }</span>
			</div>
		</c:forEach>
	</div>
	
</body>
</html>