package my.examples.firstweb.jdbc.board.exam.dao;

import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.dto.BoardList;
import my.examples.firstweb.jdbc.board.exam.util.ConnectionContextHolder;
import my.examples.firstweb.jdbc.board.exam.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

    @Override
    public Board getBoard(long seq) {
        Board board = null;

        Connection conn = ConnectionContextHolder.getConnection();
        try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_ID);) {

            //sql += "SELECT A.seq,A.user_id,B.name,A.title,A.content,A.reg_date,A.hit FROM board A";
            //sql += " LEFT JOIN user B ON A.user_id=B.id WHERE A.seq=?";

            ps.setLong(1,seq);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    long num = rs.getLong(1);
                    String userID = rs.getString(2);
                    String userName = rs.getString(3);
                    String title = rs.getString(4);
                    String content = rs.getString(5);
                    Date regDate = rs.getDate(6);
                    int hit = rs.getInt(7);

                    board = new Board(num, userID, userName, title, content, regDate, hit);
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return board;
    }

    @Override
    public BoardList getBoards(int start, int limit) {
        BoardList boardList = new BoardList();

        try {

            Connection conn = ConnectionContextHolder.getConnection();

            //String sql = "SELECT A.seq,A.user_id,B.name,A.title,A.content,A.reg_date,A.hit FROM board A";
            //sql += " LEFT JOIN user B ON A.user_id=B.id ORDER BY seq DESC LIMIT ?,?";
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_PAGING)) {

                ps.setInt(1, start);
                ps.setInt(2, limit);

                try(ResultSet rs = ps.executeQuery()){
                    //String splitSql[] = sql.split("FROM"); // 0 프롬앞, 1 프롬뒤
                    //int cnt = totalCount(splitSql[1]);

                    while (rs.next()) {
                        long num = rs.getLong(1);
                        String userID = rs.getString(2);
                        String userName = rs.getString(3);
                        String title = rs.getString(4);
                        String content = rs.getString(5);
                        Date regDate = rs.getDate(6);
                        int hit = rs.getInt(7);

                        Board board = new Board(num, userID, userName, title, content, regDate, hit);
                        boardList.add(board);
                        //boardList.setTotalCount(cnt);
                    }
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return boardList;
    }

    @Override
    public int totalCount(String splitSql) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //String splitSql = null;
        try {

            conn = ConnectionContextHolder.getConnection();
            String sql = "SELECT count(*) FROM";
            sql += splitSql;
            //" FROM board";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                count = rs.getInt("count(*)");
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(rs,ps);
        }
        return count;
    }

    @Override
    public int addBoard(Board board) {
        int result = 0;
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.INSERT)) {
                //String sql = "INSERT INTO board(user_id, title, content) VALUES(?, ?, ?)";
                //ps = conn.prepareStatement(sql);
                ps.setString(1, board.getUserID());
                ps.setString(2, board.getTitle());
                ps.setString(3, board.getContent());
                result = ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteBoard(Long id) {
        int result = 0;
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            //String sql = "DELETE FROM board WHERE seq=?";
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.DELETE);) {
                //ps = conn.prepareStatement(sql);
                ps.setLong(1, id);
                result = ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateCount(Long id) {
        int result = 0;
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            //String sql = "UPDATE board set hit = hit + 1 WHERE seq=?";
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_BY_HIT);) {
                //ps = conn.prepareStatement(sql);
                ps.setLong(1, id);
                result = ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBoard(Long id, String title, String content) {
        int result = 0;
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            //String sql = "UPDATE board set title=?, content=? WHERE seq=?";
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_BY_ID)) {
                //ps = conn.prepareStatement(sql);
                ps.setString(1, title);
                ps.setString(2, content);
                ps.setLong(3, id);
                result = ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
                //System.out.println(sql);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public BoardList searchList(String key, String value) {
        BoardList boardList = new BoardList();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        String search = null;
        try {
            conn = ConnectionContextHolder.getConnection();

            sql = "SELECT A.seq,A.user_id,B.name,A.title,A.content,A.reg_date,A.hit FROM board A";
            sql += " LEFT JOIN user B ON A.user_id=B.id";

            if(key.equals("title")) {
                sql += " WHERE A.title like ";
                sql += "'%"+value+"%'"+" ORDER BY A.seq desc";
            } else if(key.equals("content")) {
                sql += " WHERE A.content like ";
                sql += "'%"+value+"%'"+" ORDER BY A.seq desc";
            }
            String splitSql[] = sql.split("FROM"); // 0 프롬앞, 1 프롬뒤
            int cnt = totalCount(splitSql[1]);

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                long num = rs.getLong(1);
                String userID = rs.getString(2);
                String userName = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                Date regDate = rs.getDate(6);
                int hit = rs.getInt(7);

                Board board = new Board(num,userID,userName,title,content,regDate,hit);
                boardList.add(board);
                boardList.setTotalCount(cnt);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(rs,ps);
        }
        return boardList;
    }
}
