<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
    <h2>Đăng nhập</h2>
    <form action="LoginServlet" method="post">
        <label for="username">Tên người dùng:</label>
        <input type="text" id="username" name="username" value="<%= getUsernameFromCookie(request) %>"><br><br>
        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password"><br><br>
        
        <input type="submit" value="Đăng nhập">
    </form>
    
    <%!
        private String getUsernameFromCookie(HttpServletRequest request) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        return cookie.getValue();
                    }
                }
            }
            return "";
        }
    %>
</body>
</html>
