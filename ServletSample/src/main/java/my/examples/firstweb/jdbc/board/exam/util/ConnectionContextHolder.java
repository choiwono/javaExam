package my.examples.firstweb.jdbc.board.exam.util;

import java.sql.Connection;

public class ConnectionContextHolder {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    // 쓰레드로컬을 static으로 생성해준다.
    public static void setConnection(Connection connection) {
        threadLocal.set(connection);
    }

    public static Connection getConnection() {
        return threadLocal.get();
    }
}
