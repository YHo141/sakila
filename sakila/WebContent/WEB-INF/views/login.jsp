<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>login페이지</h1>
	<div>
		오늘 접속자 수 : ${stats.cnt} / 전체 접속자 수 : ${totalCount}
	</div>
		<form method="post" action="${pageContext.request.contextPath }/LoginServlet">
			<div>
				<input type="text" name = "id" placeholder="ID">
			</div>
			<div>
				<input type="password" name = "pw" placeholder="PW">
			</div>
			<div>
				<button type="submit">Log-in</button>
			</div>
		</form>
</body>
</html>