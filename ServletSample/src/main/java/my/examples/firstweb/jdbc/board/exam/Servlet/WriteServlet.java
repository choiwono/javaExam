package my.examples.firstweb.jdbc.board.exam.Servlet;

import my.examples.firstweb.jdbc.board.exam.dao.BoardDaoImpl;
import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.dao.BoardDao;
import my.examples.firstweb.jdbc.board.exam.service.BoardService;
import my.examples.firstweb.jdbc.board.exam.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WriteServlet", urlPatterns = "/write")
public class WriteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String mode = req.getParameter("mode");
        String seq = req.getParameter("seq");
        BoardService boardService = new BoardServiceImpl();

        Long id = 0L;
        try {
            id = Long.parseLong(seq);
        } catch(Exception err) {
            //redirect;
        }

        Board board = boardService.getBoard(id);

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
        BoardService boardService = new BoardServiceImpl();

        int result = 0;
        System.out.println(mode);

        if(mode.equals("write")) {
            String id = req.getParameter("userID");
            Board board = new Board(id, title, content);
            result = boardService.addBoard(board);

            if(result == 0) {
                System.out.println("실패!!");
            }
        } else if(mode.equals("modify")){
            String num = req.getParameter("seq");
            System.out.println(num);
            Long id = Long.parseLong(num);
            boardService.updateBoard(id,title,content);
        }

        req.setAttribute("result",result);
        resp.sendRedirect("/list");
    }
}
