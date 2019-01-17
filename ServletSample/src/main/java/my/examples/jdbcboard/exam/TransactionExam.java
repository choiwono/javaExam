package my.examples.jdbcboard.exam;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeInlineAnnotationReader;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionExam {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            conn.setAutoCommit(false);
            // 여러개의 sql이 실행
            String sql = "insert into board (title, content, name) values ('ttt333', 'ttt333', 'kim')";
            try(PreparedStatement ps = conn.prepareStatement(sql);) {
                ps.executeUpdate();
                ps.clearParameters();
                if (1 == 1) throw new RuntimeException("-_-;");
                ps.executeUpdate();
                ps.clearParameters();
            }
            conn.commit();
        }catch(Exception ex){
            try{ conn.rollback(); }catch(Exception ignore){}
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
    }
}