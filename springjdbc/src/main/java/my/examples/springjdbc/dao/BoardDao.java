package my.examples.springjdbc.dao;

import my.examples.springjdbc.dto.Board;

import java.util.List;

public interface BoardDao {
    // 게시글 전체조회
    // 게시글 1개 조회
    // 검색
    // 페이징
    public List<Board> selectAllBoards(int start,int limit);
    public Board selectBoard(Long id);
    public List<Board> searchBoards(String option,String keyword);
    public int selectAllCount();
    public long selectSearchCount(String subject,String keyword);
    public long getTotalPage(int boardCount, int list);
    public long addBoard(Board board);
    public long updateBoard(Long id,String title,String content);
    public long deleteBoard(Long id);
}