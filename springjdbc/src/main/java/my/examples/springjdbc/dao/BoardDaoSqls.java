package my.examples.springjdbc.dao;

public class BoardDaoSqls {

    public static final String SELECT_BOARDS =
            "SELECT id,title,user_id,nickname,content,regdate,read_count," +
            "group_no,group_seq,group_depth FROM board limit :start,:limit";
    public static final String SELECT_BOARD_BY_ID =
            "SELECT id,title,user_id,nickname,content,regdate FROM board where id=:id";
    public static final String SELECT_ALLBOARD_COUNT =
            "SELECT count(*) FROM board";
    public static final String SELECT_SEARCH_BY_TITLE =
            "SELECT id,title,user_id,nickname,content,regdate,read_count,"+
            "group_no,group_seq,group_depth FROM board"+
            "where title"+" LIKE :keyword"+" limit :start,:limit";
    public static final String UPDATE_BOARD =
            "UPDATE board set title=:title,content=:content WHERE id=:id";
    public static final String DELETE_BOARD =
            "DELETE FROM board WHERE id=:id";
}
