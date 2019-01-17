package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.Board;

import java.util.List;

// Dao : Data Access Object
public interface BoardDao {
    public Board getBoard(Long id);
    public List<Board> getBoards(int start, int limit);

    void addBoard(Board board);

    void deleteBoard(Long id);

    void updateReadCount(long id);
    void updateBoard(Board board);
}
