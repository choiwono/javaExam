package my.examples.firstweb.jdbc.board.exam.exam;

import java.sql.*;

// 1건의 데이터를 요청하는 경우
// 조건에 해당하는 데이터가 없을 수 있다.
public class SelectOneExam {
    public static void main(String[] args){
        final String driverClassname = "com.mysql.cj.jdbc.Driver"; // driver class이름도 JDBC Driver에 달라다.
        final String driverURL = "jdbc:mysql://localhost:3306/boardexam?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC"; // driver URL형식 Database마다 다르다.
        final String dbUserId = "admin";
        final String dbUserPassword = "1234";

        //long idParam = 5;
        int start = 0;
        int limit = 3;
        Connection conn = null; // mysql에 연결하기 위해 필요한 클래스
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            Class.forName(driverClassname); // driver class가 로딩.
            conn = DriverManager.getConnection(driverURL, dbUserId, dbUserPassword);
            if(conn != null) {
                System.out.println("conn ok!");
                System.out.println(conn.getClass().getName());
            }
            // b. SELECT SQL 준비 - Connection
            String sql = "select seq,user_id,user_name,title,content,pr_no,re_depth,re_ord,reg_date,hit,del_yn from board order by seq DESC limit ?,?";
            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            ps.setLong(1, start); // 첫번째 물음표에 5를 바인딩한다.
            ps.setLong(2, limit); // 첫번째 물음표에 5를 바인딩한다.
            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            while(rs.next()){
                int seq = rs.getInt(1);
                String id = rs.getString(2);
                String name = rs.getString(3);
                String title = rs.getString(4);
                String content = rs.getString(5);
                int pr_no = rs.getInt(6);
                int re_depth = rs.getInt(7);
                int re_ord = rs.getInt(8);
                Date reg_date = rs.getDate(9);
                int hit = rs.getInt(10);
                String del_yn = rs.getString(11);

                System.out.println(seq + "," + id + ", " + name + ", " + title + ", " + content + ", " + pr_no + ", "+re_depth+", "+re_ord+", "+reg_date+", "+hit+", "+del_yn);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            try{ rs.close(); } catch(Exception ignore){}
            try{ ps.close(); } catch(Exception ignore){}
            try{ conn.close(); } catch(Exception ignore){}
        }
    }
}

