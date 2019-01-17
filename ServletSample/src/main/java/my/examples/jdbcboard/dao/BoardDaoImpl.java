package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.ConnectionContextHolder;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao{
    @Override
    public Board getBoard(Long idParam) {
        Board board = null; // return할 타입을 선언한다.

        Connection conn = ConnectionContextHolder.getConnection();
        try{
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password

            // b. SELECT SQL 준비 - Connection
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_ID);) {
                // c. 바인딩 - PreparedStatement
                ps.setLong(1, idParam); // 첫번째 물음표에 5를 바인딩한다.

                // d. SQL 실행 - PreparedStatement
                try(ResultSet rs = ps.executeQuery();){ // SELECT 문장을 실행, executeUpdate() - insert, update, delete

                    // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
                    // f. e에서 읽어오지 못하는 경우도 있다.
                    if (rs.next()) {
                        long id = rs.getLong(1);
                        String title = rs.getString(2);
                        String content = rs.getString(3);
                        String name = rs.getString(4);
                        Date regdate = rs.getDate(5);
                        int readCount = rs.getInt(6);
                        String email = rs.getString(7);

                        board = new Board(id, title, content, name, regdate, readCount, email);
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        List<Board> list = new ArrayList<>();
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            Connection conn = ConnectionContextHolder.getConnection();
            // b. SELECT SQL 준비 - Connection
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_PAGING);) {
                // c. 바인딩 - PreparedStatement
                ps.setLong(1, start); // 첫번째 물음표에 5를 바인딩한다.
                ps.setInt(2, limit);

                // d. SQL 실행 - PreparedStatement
                try(ResultSet rs = ps.executeQuery();) { // SELECT 문장을 실행, executeUpdate() - insert, update, delete

                    // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
                    // f. e에서 읽어오지 못하는 경우도 있다.
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        String title = rs.getString(2);
                        String content = rs.getString(3);
                        String name = rs.getString(4);
                        Date regdate = rs.getDate(5);
                        int readCount = rs.getInt(6);
                        String email = rs.getString(7);

                        Board board = new Board(id, title, content, name, regdate, readCount, email);
                        list.add(board);
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void addBoard(Board board) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.INSERT);) {
                ps.setString(1, board.getTitle());
                ps.setString(2, board.getEmail());
                ps.setString(3, board.getName());
                ps.setString(4, board.getContent());
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBoard(Long id) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.DELETE);) {
                ps.setLong(1, id);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateBoard(Board board) {

    }

    @Override
    public void updateReadCount(long id) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_BY_HIT);) {
                ps.setLong(1, id);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
