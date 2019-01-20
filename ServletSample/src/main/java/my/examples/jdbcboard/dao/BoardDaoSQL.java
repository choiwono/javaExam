package my.examples.jdbcboard.dao;

public class BoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT A.id,A.title,A.content,A.nickname,A.regdate,A.read_count,A.user_id,A.group_no,"+
                    "A.group_seq,A.group_depth FROM board A LEFT JOIN USER B ON A.id=B.id WHERE A.id=?";

    public static final String SELECT_BY_PAGING =
            "SELECT A.id,A.title,A.content,A.nickname,A.regdate,A.read_count,A.user_id,A.group_no,"+
                    " A.group_seq,A.group_depth FROM board A LEFT JOIN USER B ON A.id=B.id"+
                    " ORDER BY A.group_no DESC, A.group_seq ASC LIMIT ?,?";

    public static final String INSERT =
            "INSERT INTO board (title,user_id,nickname,content) VALUE(?,?,?,?)";

    public static final String UPDATE_BY_HIT =
            "UPDATE board SET read_count=read_count+1 WHERE id=?";

    public static final String UPDATE_BY_BOARD =
            "UPDATE board SET title=?, content=? WHERE id=?";

    public static final String DELETE =
            "DELETE FROM board WHERE id=?";

    public static final String SELECT_LAST_INSERT_ID =
            "SELECT LAST_INSERT_ID()";

    public static final String UPDATE_LAST_INSERT_ID =
            "UPDATE board SET group_no=? WHERE id=?";

    public static final String UPDATE_GROUP_SEQ_GT =
            "UPDATE board SET group_seq = group_seq +1 WHERE group_no=? and group_seq > ?";

    public static final String INSERT_RE =
            "INSERT INTO board (title,user_id,nickname,content,group_no,group_seq,group_depth)" +
                    "value(?,?,?,?,?,?,?)";
    public static final String SELECT_TOTAL_COUNT =
            "SELECT COUNT(*) FROM board";

    /*public static final String SELECT_BY_SEARCH_PAGING =
            "SELECT A.id,A.title,A.content,A.nickname,A.regdate,A.read_count,A.user_id,A.group_no,"+
                    " A.group_seq,A.group_depth FROM board A LEFT JOIN USER B ON A.id=B.id"+
                    " WHERE ? LIKE '%제목%'";*/
                    //"ORDER BY A.group_no DESC, A.group_seq ASC LIMIT ?,?";
}
