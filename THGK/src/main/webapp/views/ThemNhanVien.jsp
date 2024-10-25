<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<!-- Header -->
		<div class="header">
			<p>21090071_DangLeHuuTien</p>
		</div>
		<!-- Content -->
		<div class="menu">
		<a href="${pageContext.request.contextPath}/list">Danh sach nhan vien</a> ||
		<a href="${pageContext.request.contextPath}/nhanVienForm">Danh sach nhan vien</a>
		</div>
		<h1>Danh Sach Nhan Vien</h1>
		<form action="ThemNhanVienServlet" method="post">
			<label>Ten NV</label> <input type="text" name="tenNV" required><br>
			<label>Dia chi</label> <input type="text" name="diaChi" required><br>
			<label>email</label> <input type="text" name="email" required><br>
			<label>dien thoai</label> <input type="text" name="dienThoai" required><br> 
			<label>maPB</label> <input type="text" name="maPhongBan" required><br>
			<input class="submit" type="submit" value="them">
		</form>
	</div>
</body>
</html>