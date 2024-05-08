import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Xóa session
        HttpSession session = request.getSession();
        session.invalidate();

        // Lưu thông tin đăng nhập vào cookie nếu người dùng đã chọn checkbox
        String remember = request.getParameter("remember");
        if (remember != null && remember.equals("on")) {
            Cookie rememberCookie = new Cookie("remember", "true");
            rememberCookie.setMaxAge(30 * 24 * 60 * 60); // Cookie tồn tại trong 30 ngày
            response.addCookie(rememberCookie);
        }

        // Chuyển hướng người dùng trở lại trang đăng nhập
        response.sendRedirect("login.jsp");
    }
}
