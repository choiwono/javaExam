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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    private static final int size = 10;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. page 값을 파라미터로 읽어들인다. 값이 없으면 기본값은 1페이지로 한다.

        BoardDao boardDao = new BoardDaoImpl();
        List<Board> boards = new ArrayList<>();
        String pageStr = req.getParameter("page");
        String tbName = "board"; // 테이블명 지정

        String search = req.getParameter("search");
        String keyword = req.getParameter("keyword");

        int page = 1;
        try{
            page = Integer.parseInt(pageStr);
        } catch(Exception ignore){}

        int start = page * size - size;
        int limit = size;

        if(search != null) {
            boards = boardDao.searchList(search,keyword);
        } else {
            boards = boardDao.getBoards(start, limit);
        }

        int totalCount = boardDao.totalCount(tbName); // 총 리스트 카운트
        int totalPage = totalCount / size; // 총페이지

        if(totalCount % size > 0) { // 총페이지 카운트 ++
            totalPage++;
        }

        req.setAttribute("page",page); // 페이지
        req.setAttribute("boards", boards); // 게시판정보
        req.setAttribute("totalPage",totalPage); // 총페이지

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}

