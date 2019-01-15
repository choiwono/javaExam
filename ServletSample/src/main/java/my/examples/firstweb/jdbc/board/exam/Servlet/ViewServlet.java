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
            BoardDao boardDao = new BoardDaoImpl();
            Board board = boardDao.getBoard(seq);

            if(board == null){
                // 오류 화면으로 redirect
                return;
            }
            req.setAttribute("board", board);
            req.setAttribute("page", page);
            req.setAttribute("mode",mode);

            boardDao.updateCount(seq);

            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/WEB-INF/views/view.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
