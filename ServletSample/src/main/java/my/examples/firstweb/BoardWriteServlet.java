package my.examples.firstweb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BoardWriteServlet", urlPatterns = "/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String mode = req.getParameter("mode");
        /*req.setAttribute("name",name);
        req.setAttribute("password",password);
        req.setAttribute("title",title);
        req.setAttribute("content",content);*/
        System.out.println(mode);

        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }
}