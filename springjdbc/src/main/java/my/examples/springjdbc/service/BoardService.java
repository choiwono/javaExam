package my.examples.springjdbc.service;

import my.examples.springjdbc.dto.Board;

import java.util.List;

public interface BoardService {
    public List<Board> selectAllBoards(int start, int limit);
    public Board selectBoard(Long id);
    public List<Board> searchBoards(String option,String keyword);
    public int selectAllCount();
    public long selectSearchCount(String subject,String keyword);
    public long getTotalPage(int boardCount, int list);
    public long addBoard(Board board);
    public long updateBoard(Long id,String title,String content);
    public long deleteBoard(Long id);
}
