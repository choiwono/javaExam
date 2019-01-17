package my.examples.firstweb.jdbc.board.exam.service;

import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.dto.BoardList;

import java.util.List;

public interface BoardService {
    public Board getBoard(long seq);
    public BoardList getBoards(int page);
    public int totalCount(String splitSql);
    public int addBoard(Board board);
    public int deleteBoard(Long id);
    public int updateCount(Long id);
    public int updateBoard(Long seq,String title,String content);
    public BoardList searchList(String str, String keyword);
}
