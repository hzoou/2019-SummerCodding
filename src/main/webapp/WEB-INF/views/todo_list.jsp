<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.list_title {
	height: 65px;
	padding: 0px 0px 0px 20px;
	background: #747474;
	color: #fff;
	font-size: 23px;
	font-weight: bold;
	line-height: 65px;
	width: 300px;
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
		<c:forEach items="${list }" var="todolist">
			<div class="list_content">
				<input type="checkbox"><br> <span class=content_main>${todolist.title }</span>
				<span class=content_content>${todolist.content }</span> <span
					class=content_sub>우선순위:${todolist.sequence }
					마감기한:${todolist.limitdate }</span>
			</div>
		</c:forEach>
	</div>
	<div class=list>
		<div class=list_title>DONE</div>
	</div>

</body>
</html>