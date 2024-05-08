<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
</head>
<body>
    <h1>Chào mừng, <%= session.getAttribute("username") %>!</h1>
    
    <div>
    	<a href="logout"><button type="button">Đăng xuất</button></a>
    </div>
</body>
</html>