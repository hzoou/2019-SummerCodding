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
<link type="text/css" rel="stylesheet" href="resources/main.css">
<script type="text/javascript">
	opener.document.location.reload();
	self.close();
	
	//등록확인
	function regBtn_click() {
		var reg = confirm('할일을 등록하시겠습니까?');
		if (reg) {
			var width = 520;
		    var height = 290;
		    var top = (screen.availHeight - height) / 2;
		    var left = (screen.availWidth - width) / 2;
		    var strFeature;
		    strFeature = 'height=' + height + ',width=' + width + ',menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=yes,top=' + top + ',left=' + left

			window.open("/todolist/reg_btn", "a", strFeature);
		} 
	}
	
	//수정확인
	function editBtn_click() {
		var id = event.srcElement.id;
		var edit = confirm('항목을 수정하시겠습니까?');
		if (edit) {
			var url = "/todolist/edit_btn?id="+id;
			
			var width = 520;
		    var height = 290;
		    var top = (screen.availHeight - height) / 2;
		    var left = (screen.availWidth - width) / 2;
		    var strFeature;
		    strFeature = 'height=' + height + ',width=' + width + ',menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=yes,top=' + top + ',left=' + left

			window.open(url, "a", strFeature);
		} 
	}
	
	//삭제확인
	function removeBtn_click() {
		var id = event.srcElement.id;
		var remove = confirm('항목을 삭제하시겠습니까?');
		if (remove) {
			self.location.href = "/todolist/remove?id="+id;
		} 
	}
	
	//완료 또는 취소확인
	function check_click() {
		var id = event.srcElement.id;
		var type = document.getElementById(id).value
		if (type == 'todo') {
			var complete = confirm('항목을 완료하셨습니까?');
			if (complete) {
				self.location.href = "/todolist/complete?id="+id;
			} else {
				document.getElementById(id).checked = false; 
			}
		} else {
			var cancel = confirm('항목에 대한 완료를 취소하시겠습니까?');
			if (cancel) {
				self.location.href = "/todolist/cancel?id="+id;
			} else {
				document.getElementById(id).checked = true; 
			}
		}
	}
	
</script>
</head>
<body>
	<p>MY TODO LIST<br></p>
	<div class="list">
		<input type="button" class="regBtn" value="새로운 TODO 등록" onclick="regBtn_click();" />
	</div>

	<div class="main">
		<div class="list">
			<div class="list_title">TODO</div>
			<c:forEach items="${todoList }" var="todolist">
				<div class="list_content">
					<input type="checkbox" class="checkbox" value="todo" id="${todolist.id }" onclick="check_click();" />
					<input type="button" class="btn" id="${todolist.id }" value="X" onclick="removeBtn_click();" />
					<input type="button" class="btn" id="${todolist.id }" value="edit" onclick="editBtn_click();" /><br> 
					
					<span class="content_main">${todolist.title }</span>
					<span class="content_content">${todolist.content }</span> 
					<span class="content_sub">
						우선순위:${todolist.sequence } 
						<label class="deadline">마감기한:${todolist.deadline }</label> 
						<label class="notice">마감</label> 
					</span>
				</div>
			</c:forEach>
		</div>

		<div class="list">
			<div class="list_title">DONE</div>
			<c:forEach items="${doneList }" var="donelist">
				<div class="list_content">
					<input type="checkbox" class="checkbox" value="done" id="${donelist.id }" checked="checked" onclick="check_click();" />
					<input type="button" class="btn" id="${donelist.id }" value="X" onclick="removeBtn_click();" />
					<input type="button" class="btn" id="${donelist.id }" value="edit" onclick="editBtn_click();" /><br>
					 
					<span class="content_main">${donelist.title }</span>
					<span class="content_content">${donelist.content }</span> 
					<span class="content_sub">
						우선순위:${donelist.sequence } 
						<label class="deadline">마감기한:${donelist.deadline }</label> 
						<label class="notice">마감</label> 
					</span>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<script>
		//마감기한 확인
		var deadline = document.getElementsByClassName('deadline');
		var notice = document.getElementsByClassName('notice');
		
		for (var i = 0; i < deadline.length; i++) {
			var deadlineDate = deadline[i].innerText.slice(5,15);
			var today = new Date().toISOString().slice(0, 10);
			//마감기한이 있는 경우 마감기한 표시
			if (deadlineDate != "") {
				deadline[i].style.display = 'inline';
				//마감기한이 지난 경우 마감알림 표시
				if (deadlineDate < today) {
					notice[i].style.display = 'inline';
				}
			}		
		}
	</script>
</body>
</html>