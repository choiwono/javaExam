package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.*;

// 1건의 데이터를 요청하는 경우
// 조건에 해당하는 데이터가 없을 수 있다.
public class SelectOneExam {
    public static void main(String[] args){
        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(5L);
        System.out.println(board);
    }
}
