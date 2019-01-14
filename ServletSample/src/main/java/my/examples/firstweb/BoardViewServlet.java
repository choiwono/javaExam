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

@WebServlet(name = "BoardViewServlet", urlPatterns = "/board/view")
public class BoardViewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardList boardlist = new BoardList();
        boardlist.add(new Board("kim", "title3", "content3","1"));
        boardlist.add(new Board("lee", "title2", "content2","2"));
        boardlist.add(new Board("hong", "title1", "content1","3"));
        List<Board> list = boardlist.getBoardList();

        String id = req.getParameter("id");
        int number = Integer.parseInt(id);

        req.setAttribute("list", list.get(number-1));

        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/view.jsp");
        requestDispatcher.forward(req, resp);
    }
}