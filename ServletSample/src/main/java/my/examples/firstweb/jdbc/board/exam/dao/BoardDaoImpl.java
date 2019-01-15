package my.examples.firstweb.jdbc.board.exam.dao;

import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.util.BoardDao;
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

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "";
            sql += "SELECT A.seq,A.user_id,B.name,A.title,A.content,A.reg_date,A.hit FROM board A";
            sql += " LEFT JOIN user B ON A.user_id=B.id WHERE A.seq=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1,seq);
            rs = ps.executeQuery();

            if(rs.next()) {
                long num = rs.getLong(1);
                String userID = rs.getString(2);
                String userName = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                Date regDate = rs.getDate(6);
                int hit = rs.getInt(7);

                board = new Board(num,userID,userName,title,content,regDate,hit);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            // 가장 늦게 연결한 순으로 거꾸로 닫는다.
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            DBUtil.close(rs, ps, conn);
        }

        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        List<Board> boardList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            conn = DBUtil.getInstance().getConnection();
            if(conn != null) {
                System.out.println("연결 되었습니다.");
                System.out.println(conn.getClass().getName());
            }

            String sql = "SELECT A.seq,A.user_id,B.name,A.title,A.content,A.reg_date,A.hit FROM board A";
            sql += " LEFT JOIN user B ON A.user_id=B.id ORDER BY seq DESC LIMIT ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,limit);

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
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return boardList;
    }
    @Override
    public int totalCount(String tbName) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            conn = DBUtil.getInstance().getConnection();
            if(conn != null) {
                System.out.println("연결 되었습니다.");
                System.out.println(conn.getClass().getName());
            }

            String sql = "SELECT count(*) FROM "+tbName+"";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                count = rs.getInt("count(*)");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return count;
    }

    @Override
    public int addBoard(Board board) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try{
            conn = DBUtil.getInstance().getConnection();
            String sql = "INSERT INTO board(user_id, title, content) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, board.getUserID());
            ps.setString(2, board.getTitle());
            ps.setString(3, board.getContent());
            result = ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            System.out.println(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(ps, conn);
        }
        return result;
    }

    @Override
    public int deleteBoard(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try{
            conn = DBUtil.getInstance().getConnection();
            String sql = "DELETE FROM board WHERE seq=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            result = ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            System.out.println(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(ps, conn);
        }
        return result;
    }

    @Override
    public int updateCount(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try{
            conn = DBUtil.getInstance().getConnection();
            String sql = "UPDATE board set hit = hit + 1 WHERE seq=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            result = ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            System.out.println(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(ps, conn);
        }
        return result;
    }

    @Override
    public int updateBoard(Long id, String title, String content) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try{
            conn = DBUtil.getInstance().getConnection();
            String sql = "UPDATE board set title=?, content=? WHERE seq=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,content);
            ps.setLong(3,id);
            result = ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            System.out.println(sql);

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(ps, conn);
        }
        return result;
    }

    @Override
    public List<Board> searchList(String str, String keyword) {
        List<Board> boardList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            if(conn != null) {
                System.out.println("연결 되었습니다.");
                System.out.println(conn.getClass().getName());
            }
            switch(str) {
                case "all" :
                sql = "SELECT A.seq,A.user_id,B.name,A.title,A.content,A.reg_date,A.hit FROM board A";
                sql += " LEFT JOIN user B ON A.user_id=B.id";
                break;

                case "subject" :
                sql = "SELECT A.seq,A.user_id,B.name,A.title,A.content,A.reg_date,A.hit FROM board A";
                sql += " LEFT JOIN user B ON A.user_id=B.id WHERE A.title like ? ORDER BY A.seq desc";
                break;

                case "content" :
                sql = "SELECT A.seq,A.user_id,B.name,A.title,A.content,A.reg_date,A.hit FROM board A";
                sql += " LEFT JOIN user B ON A.user_id=B.id WHERE A.content like ? ORDER BY A.seq desc";
                break;
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+keyword+"%");
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
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return boardList;
    }
}
