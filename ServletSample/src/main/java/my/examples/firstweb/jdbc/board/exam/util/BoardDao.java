package my.examples.firstweb.jdbc.board.exam.util;

import my.examples.firstweb.jdbc.board.exam.dto.Board;

import java.util.List;

public interface BoardDao {
    public Board getBoard(long seq);
    public List<Board> getBoards(int start,int limit);
    public int totalCount(String tbName);
    public int addBoard(Board board);
    public int deleteBoard(Long id);
    public int updateCount(Long id);
    public int updateBoard(Long seq,String title,String content);
    public List<Board> searchList(String str,String keyword);
}
