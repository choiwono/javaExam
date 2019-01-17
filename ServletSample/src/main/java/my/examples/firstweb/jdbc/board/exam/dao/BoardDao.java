package my.examples.firstweb.jdbc.board.exam.dao;

import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.dto.BoardList;

import java.util.List;

public interface BoardDao {
    public Board getBoard(long seq);
    public BoardList getBoards(int start,int limit);
    public int totalCount(String splitSql);
    public int addBoard(Board board);
    public int deleteBoard(Long id);
    public int updateCount(Long id);
    public int updateBoard(Long seq,String title,String content);
    public BoardList searchList(String str, String keyword);
}
