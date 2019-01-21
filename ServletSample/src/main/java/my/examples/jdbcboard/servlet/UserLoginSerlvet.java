package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.service.UserService;
import my.examples.jdbcboard.service.UserServiceImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserLoginSerlvet", urlPatterns = "/login")
public class UserLoginSerlvet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirectUrl = req.getParameter("redirect");

        req.setAttribute("redirect",redirectUrl);
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/loginform.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");
        String redirect = req.getParameter("redirect");

        if(redirect == null) { // redirect경로가 없을경우 무조건 list 페이지로 이동
            redirect = "/list";
        }

        UserService userService = UserServiceImpl.getInstance();
        User user = userService.getUserByEmail(email);
        if(user.getPasswd() != null){
            PasswordEncoder passwordEncoder =
                    PasswordEncoderFactories.createDelegatingPasswordEncoder();
            boolean matches = passwordEncoder.matches(passwd, user.getPasswd());
            if(matches){
                // 로그인정보를 세션에 저장.
                HttpSession session = req.getSession();
                session.setAttribute("logininfo", user);
                System.out.println("암호가 맞아요.");
            } else {
                // 암호가 틀렸어요.
                System.out.println("암호가 틀렸어요.");
            }
        }
        // 로그인 성공했다면
        resp.sendRedirect(redirect);
    }
}
