package my.examples.firstweb.jdbc.board.exam.util;

import my.examples.firstweb.jdbc.board.exam.dto.Board;

import java.util.List;

public interface BoardDao {
    public Board getBoard(int seq);
    public List<Board> getBoards(int seq);
}
