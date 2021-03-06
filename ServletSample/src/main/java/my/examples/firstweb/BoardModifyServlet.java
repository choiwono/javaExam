package my.examples.firstweb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BoardModifyServlet", urlPatterns = "/board/modify")
public class BoardModifyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/modify.jsp");
        requestDispatcher.forward(req, resp);
    }
}