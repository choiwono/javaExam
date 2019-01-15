package my.examples.firstweb.jdbc.board.exam.util;

import com.zaxxer.hikari.HikariConfig;

import javax.sql.DataSource;

public class HikariCPTest {
    private static DataSource datasource;
    public static DataSource getDataSource() {
        if(datasource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/boardexam");
            config.setUsername("admin");
            config.setPassword("1234");

            config.setMaximumPoolSize(10);
            config.setAutoCommit(false);
            config.addDataSourceProperty("cachePrepStms","true");
            config.addDataSourceProperty("prepStmtCacheSize","250");

        }
        return datasource;
    }
}
