package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

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
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        String search = req.getParameter("search");
        String keyword = req.getParameter("keyword");

        BoardService boardService = new BoardServiceImpl();
        List<Board> boards = new ArrayList<>();
        final int SIZE = 10;
        int page = 1;
        int totalPage = 1;
        int totalCount = 1;
        try{
            page = Integer.parseInt(pageStr);
        }catch(Exception ignore){}

        if(search != null && keyword != null) { //검색 옵션과 검색할 내용이 둘다 있을경우
            boards = boardService.searchBoards(search,keyword,page);
            totalCount = boardService.getSearchTotalPage(search,keyword);
        } else {
            boards = boardService.getBoards(page);
            totalCount = boardService.getTotalPage();
        }

        totalPage = totalCount / SIZE;
        if(totalCount % SIZE > 0) {
            totalPage++;
        }

        req.setAttribute("boards", boards);
        req.setAttribute("page", page);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("search",search);
        req.setAttribute("keyword",keyword);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
