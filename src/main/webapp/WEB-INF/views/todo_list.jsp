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
<style>
* {
	background-color: #f2f2f2;
}

h1 {
	text-align: center;
}

#next_btn {
	float: right;
	width: 150px;
	background-color: #c00;
	font-weight: bold;
	text-align: center;
	line-height: 30px;
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
    display: inline-block;
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
	<div id=next_btn>
		<a href="<%=path%>/reg_btn">새로운 TODO 등록</a>
	</div>

	<div class=list>
		<div class=list_title>TODO</div>
		<c:forEach items="${todoList }" var="todolist">
			<div class="list_content">
				<input type="checkbox" class="checkbox"><input type="button" class="btn" value="X" id="remove_btn"><input type="button" class="btn" value="edit" id="edit_btn"><br> 
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
				<input type="checkbox" class="checkbox"><input type="button" class="btn" value="X" id="remove_btn"><input type="button" class="btn" value="edit" id="edit_btn"><br> <span class=content_main>${donelist.title }</span>
				<span class=content_content>${donelist.content }</span> <span
					class=content_sub>우선순위:${donelist.sequence }
					마감기한:${donelist.limitdate }</span>
			</div>
		</c:forEach>
	</div>
	
</body>
</html>