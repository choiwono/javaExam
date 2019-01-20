package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.Board;

import java.util.List;

public interface BoardService {
    // page에 해당하는 목록을 읽어온다.
    // 전체 건수를 읽어온다.
    // 글을 읽어온다. (글읽기 + 조회수증가)
    // 글을 삭제한다.
    List<Board> getBoards(int page);
    Board getBoard(Long id);
    void deleteBoard(Long id);
    void updateBoard(Board board);
    void addBoard(Board board);
    void addReBoard(Board board);
    List<Board> searchBoards(String search, String keyword, int page);
    int getTotalPage();
    int getSearchTotalPage(String search, String keyword);
}
