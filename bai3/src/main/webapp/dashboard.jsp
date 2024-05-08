<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
    <h2>Chào mừng, <%= session.getAttribute("username") %>!</h2>
    <form action="LogoutServlet" method="post">
        <input type="checkbox" id="remember" name="remember" <% if (isRemembered(request)) out.print("checked"); %>>
        <label for="remember">Lưu thông tin đăng nhập</label><br><br>
        <input type="submit" value="Đăng xuất">
    </form>
    
    <%!
        private boolean isRemembered(HttpServletRequest request) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("remember") && cookie.getValue().equals("true")) {
                        return true;
                    }
                }
            }
            return false;
        }
    %>
</body>
</html>