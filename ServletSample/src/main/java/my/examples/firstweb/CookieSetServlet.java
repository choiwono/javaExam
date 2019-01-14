package my.examples.firstweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieSetServlet", urlPatterns = "/cookieset")
public class CookieSetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Cookie cookie = new Cookie("counter", "1");
        cookie.setPath("/");
        //cookie.setMaxAge(60 * 60 * 24 * 365); // 브라우저를 닫을 때까지.

        resp.addCookie(cookie);

        out.println("쿠키를 설정합니다.");
    }
}

