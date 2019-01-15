package my.examples.firstweb.jdbc.board.exam.dto;

import java.util.ArrayList;
import java.util.List;

public class BoardList {
    private List<Board> boardList;
    // LocaDateTime 에 대하여 공부.
    public BoardList(){
        boardList = new ArrayList<>();
    }
    public void add(Board board) {
        boardList.add(board);
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }
}
