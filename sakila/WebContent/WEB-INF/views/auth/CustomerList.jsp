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
	<h2>CustomerList ������</h2>
	<table id="staff">
				<tr>
					<td rowspan="2"><a href="${pageContext.request.contextPath}/auth/StaffListServlet" class='fas fa-user-circle' style='font-size:60px'></a></td>
					<td>${loginStaff.storeId}����</td>
				</tr>
	</table>

		<div>
			<span>${loginStaff.username}</span>�����ڴ�
		</div>

	<div>
		<a href="${pageContext.request.contextPath}/auth/LogoutServlet" class="btn btn-danger" role="button">�α׾ƿ�</a>
	</div>
	
	
	
	<ul class="linkedList">
			<li class="line">
				<a href="#">Ȩ</a>
			</li>
			
			<li>
				<a href="#">��ȭ �ݳ�</a>
			</li>
			
			<li class="line">
				<a href="${pageContext.request.contextPath}/auth/CustomerServlet">ȸ����� ����</a>
			</li>
			
			<li>
				<a href="#">��ȭ��� ����</a>
			</li>
			
			<li>
				<a href="#">��ȭ��� ����</a>
			</li>
			
			<li>
				<a href="#">��ȭ��� ����</a>
			</li>
			
			<li>
				<a href="#">��ȭ �⿬��� ���</a>
			</li>
			
			<li class="line">
				<a href="#">���� ���</a>
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
										<th>����</th>
										<th>�̸�</th>
										<th>����ó</th>
										<th>Ȱ������</th>
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