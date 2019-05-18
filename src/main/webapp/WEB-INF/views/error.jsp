<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<input type="hidden" id="errorMessage" value="${message }" />
	
	<script type="text/javascript">
	 	var errorMessage = document.getElementById('errorMessage').value;
	 	alert(errorMessage);
	 	self.location.href = "/todolist";
	</script>
</body>
</html>