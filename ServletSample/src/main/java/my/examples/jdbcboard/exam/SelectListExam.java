package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.*;
import java.util.List;

/*
0건 이상의 목록을 읽어올 때.
mysql> SELECT id, title, content, name, regdate, read_count
    -> FROM board
    -> ORDER BY id DESC LIMIT 0, 3;
+----+--------+----------+------+---------------------+------------+
| id | title  | content  | name | regdate             | read_count |
+----+--------+----------+------+---------------------+------------+
|  8 | title8 | content8 | kim8 | 2019-01-11 02:48:32 |          0 |
|  7 | title7 | content7 | kim7 | 2019-01-11 02:47:58 |          0 |
|  6 | title6 | content6 | kim6 | 2019-01-11 02:47:58 |          0 |
+----+--------+----------+------+---------------------+------------+
3 rows in set (0.00 sec)
 */
public class SelectListExam {
    public static void main(String[] args){
        BoardDao boardDao = new BoardDaoImpl();
        List<Board> boards = boardDao.getBoards(0, 3);
        for(Board board : boards){
            System.out.println(board);
        }
    }
}
