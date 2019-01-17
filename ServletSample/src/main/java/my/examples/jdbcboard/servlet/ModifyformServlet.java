package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ModifyServlet", urlPatterns = "/modify")
public class ModifyformServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("logininfo");
        String idStr = req.getParameter("id");
        Long id = 0L;

        if(user == null){
            System.out.println("-_-;;;;; 로그인 부탁!!");
            resp.sendRedirect("/login");
            return;
        } else {
            id = Long.parseLong(idStr);
            System.out.println("로그인 OK");
        }
        BoardService boardService = new BoardServiceImpl();
        Board board = boardService.getBoard(id);
        req.setAttribute("board", board);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/modify.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Long id = Long.parseLong(req.getParameter("id"));

        BoardService boardService = new BoardServiceImpl();
        Board board = new Board(title, content, name, id);

        boardService.updateBoard(board);
        resp.sendRedirect("/list");
    }
}
