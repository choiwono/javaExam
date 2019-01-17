package my.examples.firstweb.jdbc.board.exam.Servlet;

import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.dto.BoardList;
import my.examples.firstweb.jdbc.board.exam.service.BoardService;
import my.examples.firstweb.jdbc.board.exam.service.BoardServiceImpl;

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
        String pageStr = req.getParameter("page");
        String search = req.getParameter("search");
        String keyword = req.getParameter("keyword");

        BoardList boards = new BoardList();
        BoardService boardService = new BoardServiceImpl();

        int page = 1;
        try{
            page = Integer.parseInt(pageStr);
        } catch(Exception ignore){}

        if(search != null && keyword != null) {
            boards = boardService.searchList(search,keyword);
        } else {
            boards = boardService.getBoards(page);
        }

        int totalCnt = boards.getTotalCount(); // 총페이지값 받아오기
        int totalPage =  totalCnt / size;
        if(totalCnt % size > 0) {
            totalPage++;
        }
        //int totalPage = 3;
        req.setAttribute("page",page); // 페이지
        req.setAttribute("boards", boards); // 게시판정보
        req.setAttribute("totalPage",totalPage); // 총페이지

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}

