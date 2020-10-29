<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="EUC-KR">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>CustomerList.jsp</title>
        <link href="/sakila/sakilaStyle.css" rel="stylesheet" type="text/css" />
        <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>


</head>
<body>
<div id="bg">
<div id="outer">
<div id="main">
<div id="sidebar">
	<h2>CustomerList 페이지</h2>
	<table id="staff">
				<tr>
					<td rowspan="2"><a href="${pageContext.request.contextPath}/auth/StaffListServlet" class='fas fa-user-circle' style='font-size:60px'></a></td>
					<td>${loginStaff.storeId}지점</td>
				</tr>
	</table>

		<div>
			<span>${loginStaff.username}</span>관리자님
		</div>

	<div>
		<a href="${pageContext.request.contextPath}/auth/LogoutServlet" class="btn btn-danger" role="button">로그아웃</a>
	</div>
	
	
	
	<ul class="linkedList">
			<li class="line">
				<a href="#">홈</a>
			</li>
			
			<li>
				<a href="#">영화 반납</a>
			</li>
			
			<li class="line">
				<a href="${pageContext.request.contextPath}/auth/CustomerServlet">회원목록 관리</a>
			</li>
			
			<li>
				<a href="#">영화목록 관리</a>
			</li>
			
			<li>
				<a href="#">영화재고 관리</a>
			</li>
			
			<li>
				<a href="#">영화배우 관리</a>
			</li>
			
			<li>
				<a href="#">영화 출연배우 등록</a>
			</li>
			
			<li class="line">
				<a href="#">매장 통계</a>
			</li>
			
			<li class="last">
				<a href="#">MVP</a>
			</li>
			
	</ul>
	
</div>
		<div id="content" class="table-dark">
			<h2>Customer List</h2>
							
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th>순번</th>
										<th>이름</th>
										<th>연락처</th>
										<th>활성여부</th>
									</tr>
								</thead>
								
								<tbody>
									<c:forEach var="l" items="${list}">
										<tr>
											<td>${l.customerId}</td>
											<td>${l.customerName}</td>
											<td>${l.customerPhone}</td>
											<td>${l.customerNotes}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
		
			<br class="clear" />
		</div>
</div>
</div>
</div>
</body>
</html>