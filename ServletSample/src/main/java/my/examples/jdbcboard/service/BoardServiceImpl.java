package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService{
    public static final int SIZE = 10;

    @Override
    public List<Board> getBoards(int page) {
        BoardDao boardDao = new BoardDaoImpl();

        int start = page * SIZE -SIZE;
        int limit = SIZE;

        List<Board> boards = new ArrayList<>();
        try(Connection conn = DBUtil.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            boards = boardDao.getBoards(start, limit);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return boards;
    }

    @Override
    public Board getBoard(Long id) {
        Board board = null;
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            board = boardDao.getBoard(id);
            boardDao.updateReadCount(id);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return board;
    }

    @Override
    public void deleteBoard(Long id) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.deleteBoard(id);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public void addBoard(Board board) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);

            boardDao.addBoard(board);
            Long lastInsertId = boardDao.getLastInsertId();
            boardDao.updateLastInsertId(lastInsertId);

            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public void addReBoard(Board board) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);

            Board oBoard = boardDao.getBoard(board.getId());
            board.setGroupSeq(oBoard.getGroupSeq());
            board.setGroupNo(oBoard.getGroupNo());
            board.setGroupDepth(oBoard.getGroupDepth());
            boardDao.updateGroupSeqGt(oBoard.getGroupNo(), oBoard.getGroupSeq());
            boardDao.addReBoard(board);

            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public List<Board> searchBoards(String search, String keyword, int page) {
        BoardDao boardDao = new BoardDaoImpl();
        int start = page * SIZE -SIZE;
        int limit = SIZE;
        List<Board> boards = new ArrayList<>();

        try(Connection conn = DBUtil.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            boards = boardDao.searchBoards(search,keyword,start,limit);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return boards;
    }

    @Override
    public int getTotalPage() {
        BoardDao boardDao = new BoardDaoImpl();
        int totalPage = 1;

        try(Connection conn = DBUtil.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            totalPage = boardDao.getTotalPage();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return totalPage;
    }

    @Override
    public int getSearchTotalPage(String search, String keyword) {
        BoardDao boardDao = new BoardDaoImpl();
        int totalPage = 1;

        try(Connection conn = DBUtil.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            totalPage = boardDao.getSearchTotalPage(search,keyword);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return totalPage;
    }

    @Override
    public void updateBoard(Board board) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.updateBoard(board);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }
}
