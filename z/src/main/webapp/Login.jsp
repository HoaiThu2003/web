<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="css/login.css" rel="styleSheet" />
<title>Login</title>
</head>
<body>
	<c:set var="erro" value="${requestScope.erro}" />
	<div class="loginn">
		<h4 style="color: red">${erro}</h4>
		<form action="login" method="post">
			<table class="login-table">
				<tr class="login-head">
					<th colspan="3">Đăng nhập</th>
				</tr>
				<tr class="login-body">
					<td>Tài khoản:</td>
					<td><input type="text" name="taikhoan"></td>
				</tr>
				<tr class="login-body">
					<td>Mật khẩu:</td>
					<td><input type="text" name="matkhau"></td>
				</tr>
				<tr class="login-foot">
					<th class="foot-item"><input class="button" type="submit"
						name="submit" value="Đăng nhập" style="margin-left: 150px"></th>

				</tr>
				<tr>
					<th class="foot-item"><a class="text" href="dangky.jsp">Tạo
							tài khoản?</a></th>

				</tr>
			</table>
		</form>

	</div>

</body>
</html>