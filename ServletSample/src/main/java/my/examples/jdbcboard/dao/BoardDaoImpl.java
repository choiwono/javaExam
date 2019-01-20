package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.ConnectionContextHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao{
    @Override
    public Board getBoard(Long idParam) {
        Board board = null;

        Connection conn = ConnectionContextHolder.getConnection();
        try{
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_ID);) {
                ps.setLong(1, idParam); // 첫번째 물음표에 5를 바인딩한다.
                try(ResultSet rs = ps.executeQuery();){
                    board = returnBoard(rs);
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return board;
    }

    private Board returnBoard(ResultSet rs) throws SQLException {
        Board board = null;
        if (rs.next()) {
            long id = rs.getLong(1);
            String title = rs.getString(2);
            String content = rs.getString(3);
            String name = rs.getString(4);
            Date regdate = rs.getDate(5);
            int readCount = rs.getInt(6);
            String email = rs.getString(7);
            int groupNo = rs.getInt(8);
            int groupSeq = rs.getInt(9);
            int groupDepth = rs.getInt(10);

            board = new Board();
            board.setId(id);
            board.setTitle(title);
            board.setContent(content);
            board.setName(name);
            board.setRegdate(regdate);
            board.setReadCount(readCount);
            board.setEmail(email);
            board.setGroupNo(groupNo);
            board.setGroupSeq(groupSeq);
            board.setGroupDepth(groupDepth);
        }
        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        List<Board> boards = new ArrayList<>();
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            Connection conn = ConnectionContextHolder.getConnection();
            // b. SELECT SQL 준비 - Connection
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_PAGING);) {
                // c. 바인딩 - PreparedStatement
                ps.setLong(1, start);
                ps.setInt(2, limit);

                // d. SQL 실행 - PreparedStatement
                try(ResultSet rs = ps.executeQuery();) {
                    boards = returnBoards(rs);
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return boards;
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
    public Long getLastInsertId() {
        Long lastId = 0L;

        Connection conn = ConnectionContextHolder.getConnection();
        try{
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_LAST_INSERT_ID);) {
                try(ResultSet rs = ps.executeQuery();){
                    if (rs.next()) {
                        lastId = rs.getLong(1);
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lastId;
    }

    @Override
    public void updateLastInsertId(Long id) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_LAST_INSERT_ID);) {
                ps.setLong(1, id);
                ps.setLong(2, id);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateGroupSeqGt(int groupNo, int groupSeq) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_GROUP_SEQ_GT);) {
                ps.setInt(1, groupNo);
                ps.setInt(2, groupSeq);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void addReBoard(Board board) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.INSERT_RE);) {

                //title, user_id, nickname, content
                ps.setString(1, board.getTitle());
                ps.setString(2, board.getEmail());
                ps.setString(3, board.getName());
                ps.setString(4, board.getContent());
                ps.setInt(5, board.getGroupNo());
                ps.setInt(6, board.getGroupSeq() + 1);
                ps.setInt(7, board.getGroupDepth() + 1);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Board> searchBoards(String search, String keyword, int start, int limit) {
        List<Board> boards = new ArrayList<>();
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            Connection conn = ConnectionContextHolder.getConnection();
            // b. SELECT SQL 준비 - Connection
            String sql = "SELECT A.id,A.title,A.content,A.nickname,A.regdate,A.read_count,A.user_id,A.group_no,";
            sql += " A.group_seq,A.group_depth FROM board A LEFT JOIN USER B ON A.id=B.id";
            if(search.equals("title")) {
                sql += " WHERE A.title LIKE '%"+keyword+"%'";
            } else {
                sql += " WHERE A.content LIKE '%"+keyword+"%'";
            }
            sql += " ORDER BY A.group_no DESC, A.group_seq ASC LIMIT ?,?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setLong(1, start);
                ps.setInt(2, limit);

                // d. SQL 실행 - PreparedStatement
                try(ResultSet rs = ps.executeQuery();) {
                    boards = returnBoards(rs);
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return boards;
    }

    @Override
    public int getTotalPage() {
        int totalPage = 0;
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_TOTAL_COUNT);) {
                try(ResultSet rs = ps.executeQuery();){
                    while(rs.next()) {
                        totalPage += rs.getInt(1);
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return totalPage;
    }

    @Override
    public int getSearchTotalPage(String search, String keyword) {
        int totalPage = 0;
        String sql = "";
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            if(search != null && keyword != null) {
                sql = BoardDaoSQL.SELECT_TOTAL_COUNT;
                if(search.equals("title")) {
                    sql += " WHERE title LIKE '%"+keyword+"%'";
                } else {
                    sql += " WHERE content LIKE '%"+keyword+"%'";
                }
            }

            try(PreparedStatement ps = conn.prepareStatement(sql);) {
                try(ResultSet rs = ps.executeQuery();){
                    while(rs.next()) {
                        totalPage += rs.getInt(1);
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return totalPage;
    }

    private List<Board> returnBoards(ResultSet rs) throws SQLException {
        List<Board> boards = new ArrayList<>();
        while (rs.next()) {
            long id = rs.getLong(1);
            String title = rs.getString(2);
            String content = rs.getString(3);
            String name = rs.getString(4);
            Date regdate = rs.getDate(5);
            int readCount = rs.getInt(6);
            String email = rs.getString(7);
            int groupNo = rs.getInt(8);
            int groupSeq = rs.getInt(9);
            int groupDepth = rs.getInt(10);

            Board board = new Board();
            board.setId(id);
            board.setTitle(title);
            board.setContent(content);
            board.setName(name);
            board.setRegdate(regdate);
            board.setReadCount(readCount);
            board.setEmail(email);
            board.setGroupNo(groupNo);
            board.setGroupSeq(groupSeq);
            board.setGroupDepth(groupDepth);

            boards.add(board);
        }
        return boards;
    }

    @Override
    public void updateBoard(Board board) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_BY_BOARD);) {
                System.out.println(BoardDaoSQL.UPDATE_BY_BOARD);
                ps.setString(1,board.getTitle());
                ps.setString(2,board.getContent());
                ps.setLong(3,board.getId());
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
                //System.out.println(BoardDaoSQL.UPDATE_BY_BOARD);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
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
