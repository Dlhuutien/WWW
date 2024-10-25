<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<!-- Header -->
		<div class="header">
			<p>21090071_DangLeHuuTien</p>
		</div>
		<!-- Content -->
		<div class="menu">
		<a href="${pageContext.request.contextPath}/list">Danh sach nhan vien</a> ||
		<a href="${pageContext.request.contextPath}/nhanVienForm">Danh sach nhan vien</a></div>
		<h1>Danh Sach Nhan Vien</h1>
		<table border="1">
			<tr>
				<th>Ten phong ban</th>
				<th>MaNV</th>
				<th>Ten NV</th>
				<th>Email</th>
				<th>Dia chi</th>
				<th>dien thoai</th>
				<th>MaPB</th>
				<th></th>
			</tr>
			<c:forEach var="item" items="${nhanVien}">
				<tr>
					<td>${item.phongBan.tenPhongBan}</td>
					<td>${item.maNhanVien}</td>
					<td>
							<form action="${pageContext.request.contextPath}/list"
								method="post">
								<input type="hidden" name="action" value="remove"> <input
									type="hidden" name="maNhanVien" value="${item.maNhanVien}"> <input
									type="submit" value="Xóa">
							</form>
						</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>