import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember"); // Lấy giá trị từ checkbox Remember Me

        // Kiểm tra thông tin đăng nhập
        if (password.equals("123456")) { // Giả sử mật khẩu cố định là "123456"
            // Tạo session và lưu username vào session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Thiết lập cookie nếu người dùng chọn Remember Me
            if (remember != null && remember.equals("on")) {
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(30 * 24 * 60 * 60); // Cookie tồn tại trong 30 ngày
                response.addCookie(usernameCookie);
            }

            response.sendRedirect("dashboard.jsp");
        } else {
            out.println("Đăng nhập không thành công. Vui lòng thử lại.");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

        out.close();
    }
}
