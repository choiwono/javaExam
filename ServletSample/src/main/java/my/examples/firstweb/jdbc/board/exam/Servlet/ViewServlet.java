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

    @WebServlet(name = "ViewServlet", urlPatterns = "/view")
    public class ViewServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String mode = req.getParameter("mode");
            String idStr = req.getParameter("seq");
            String page = req.getParameter("page");

            Long seq = 0L;

            try{
                seq = Long.parseLong(idStr);
            } catch(Exception ex){
                // 오류 화면으로 redirect
                return;
            }
            BoardService boardService = new BoardServiceImpl();
            Board board = boardService.getBoard(seq);

            if(board == null){
                // 오류 화면으로 redirect
                return;
            }
            req.setAttribute("board", board);
            req.setAttribute("page", page);
            req.setAttribute("mode",mode);

            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/WEB-INF/views/view.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
