<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>index.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>Index ������</h1>
	<div>
		<span>${loginStaff}</span>�����ڴ�
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/LogoutServlet" class="btn btn-danger" role="button">�α׾ƿ�</a>
	</div>
</body>
</html>