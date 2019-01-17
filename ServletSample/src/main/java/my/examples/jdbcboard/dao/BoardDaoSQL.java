package my.examples.jdbcboard.dao;

public class BoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT A.id,A.title,A.content,A.nickname,A.regdate,A.read_count,A.user_id FROM board A LEFT JOIN USER B ON A.id=B.id WHERE A.id=?";

    public static final String SELECT_BY_PAGING =
            "SELECT A.id,A.title,A.content,A.nickname,A.regdate,A.read_count,A.user_id FROM board A LEFT JOIN USER B ON A.id=B.id ORDER BY A.id DESC LIMIT ?,?";

    public static final String INSERT =
            "INSERT INTO board (title,user_id,nickname,content) VALUE(?,?,?,?)";

    public static final String UPDATE_BY_HIT =
            "UPDATE board SET read_count=read_count+1 WHERE id=?";

    public static final String UPDATE_BY_BOARD =
            "UPDATE board SET title=?,nickname=?,content=? WHERE id=?";

    public static final String DELETE =
            "DELETE FROM board WHERE id=?";
}
