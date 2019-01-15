package my.examples.firstweb.jdbc.board.exam.exam;

import my.examples.firstweb.jdbc.board.exam.dao.BoardDaoImpl;
import my.examples.firstweb.jdbc.board.exam.dto.Board;
import my.examples.firstweb.jdbc.board.exam.util.BoardDao;

import java.sql.*;
import java.util.List;

// 1건의 데이터를 요청하는 경우
// 조건에 해당하는 데이터가 없을 수 있다.
public class SelectOneExam {
    public static void main(String[] args){
        BoardDao boardDao = new BoardDaoImpl();
        //Board board = boardDao.getBoard(3);
        //System.out.println(board);
        List<Board> list = boardDao.getBoards(0,3);
        for(Board board:list) {
            System.out.println(board.toString());
        }
    }
}

