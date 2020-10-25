<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="row">
<div class= "col-3"></div>
	<div class="col-6">
		<h1>login페이지</h1>
		<div>
			오늘 접속자 수 : ${stats.cnt} / 전체 접속자 수 : ${totalCount}
		</div>
		
			<form method="post" action="${pageContext.request.contextPath}/LoginServlet" class="was-validated">
				<div>
					<input type="text" name = "id" placeholder="ID" class="form-control" required>
				</div>
				<div>
					<input type="password" name = "pw" placeholder="PW" class="form-control" required>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Log-in</button>
				</div>
			</form>
	</div>
<div class= "col-3"></div>
</div>
</body>
</html>