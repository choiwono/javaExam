package my.examples.firstweb.jdbc.board.exam.service;

import my.examples.firstweb.jdbc.board.exam.dao.BoardDaoImpl;
import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.dao.BoardDao;
import my.examples.firstweb.jdbc.board.exam.dto.BoardList;
import my.examples.firstweb.jdbc.board.exam.util.ConnectionContextHolder;
import my.examples.firstweb.jdbc.board.exam.util.DBUtil;

import java.sql.Connection;

public class BoardServiceImpl implements BoardService{
    public static final int SIZE = 10;

    @Override
    public Board getBoard(long seq) {
        Board board = null;
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {

            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            board = boardDao.getBoard(seq);
            boardDao.updateCount(seq);
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
    public BoardList getBoards(int page) {
        BoardDao boardDao = new BoardDaoImpl();
        BoardList boards = new BoardList();
        int start = page * SIZE - SIZE;
        int limit = SIZE;

        Connection conn = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boards = boardDao.getBoards(start, limit);

        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return boards;
    }

    @Override
    public int totalCount(String splitSql) {
        BoardDao boardDao = new BoardDaoImpl();

        Connection conn = null;
        int totalCount = 0;
        int totalPage = 0;
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            totalCount = boardDao.totalCount(splitSql); // 총 리스트 카운트
            totalPage = totalCount / SIZE; // 총페이지

            if(totalCount % SIZE > 0) { // 총페이지 카운트 ++
                totalPage++;
            }
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }

        return totalPage;
    }

    @Override
    public int addBoard(Board board) {
        int result = 0;
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.addBoard(board);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return result;
    }

    @Override
    public int deleteBoard(Long id) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        int result = 0;
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
        return result;
    }

    @Override
    public int updateCount(Long id) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        int result = 0;
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.updateCount(id);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return result;
    }

    @Override
    public int updateBoard(Long seq, String title, String content) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        int result = 0;
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.updateBoard(seq,title,content);
            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return result;
    }

    @Override
    public BoardList searchList(String str, String keyword) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        BoardList boardList = new BoardList();

        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardList = boardDao.searchList(str,keyword);

        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return boardList;
    }
}
