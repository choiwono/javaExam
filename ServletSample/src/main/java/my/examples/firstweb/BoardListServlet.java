package my.examples.firstweb;

import my.examples.firstweb.jdbc.board.exam.dto.BoardList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BoardListServlet", urlPatterns = "/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardList boardlist = new BoardList();
        boardlist.add(new Board("kim", "title3", "content3","3"));
        boardlist.add(new Board("lee", "title2", "content2","2"));
        boardlist.add(new Board("hong", "title1", "content1","1"));
        List<Board> list = boardlist.getBoardList();

        String search = req.getParameter("search");
        String keyword = req.getParameter("keyword");

        req.setAttribute("list", list);
        req.setAttribute("search",search);
        req.setAttribute("keyword",keyword);

        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}