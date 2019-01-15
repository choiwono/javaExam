package my.examples.firstweb.jdbc.board.exam.Servlet;

import my.examples.firstweb.jdbc.board.exam.dao.BoardDaoImpl;
import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.util.BoardDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WriteServlet", urlPatterns = "/write")
public class WriteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String mode = req.getParameter("mode");
        String seq = req.getParameter("seq");

        Long id = 0L;
        try {
            id = Long.parseLong(seq);
        } catch(Exception err) {
            //redirect;
        }

        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(id);

        req.setAttribute("mode",mode);
        req.setAttribute("seq",id);
        req.setAttribute("board",board);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String mode = req.getParameter("mode");
        BoardDao boardDao = new BoardDaoImpl();

        int result = 0;
        System.out.println(mode);

        if(mode.equals("write")) {
            String id = req.getParameter("userID");
            Board board = new Board(id, title, content);
            result = boardDao.addBoard(board);
            if(result == 0) {
                System.out.println("실패!!");
            }
        } else if(mode.equals("modify")){
            String num = req.getParameter("seq");
            System.out.println(num);
            Long id = Long.parseLong(num);
            boardDao.updateBoard(id,title,content);
        }

        req.setAttribute("result",result);
        resp.sendRedirect("/list");
    }
}
