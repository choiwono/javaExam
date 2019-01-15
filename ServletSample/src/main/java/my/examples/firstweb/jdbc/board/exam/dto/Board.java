package my.examples.firstweb.jdbc.board.exam.dto;

import java.sql.Date;

public class Board {
    private long seq;
    private String userID;
    private String userName;
    private String title;
    private String content;
    private int prNo;
    private int reDepth;
    private Date regDate;
    private int reOrd;
    private int hit;
    private String delYn;

    public Board() {
        this.prNo = prNo;
        this.reDepth = reDepth;
        this.reOrd = reOrd;
        this.delYn = delYn;
    }

    public Board(String userID, String title, String content) {
        this();
        this.userID = userID;
        this.title = title;
        this.content = content;
    }

    public Board(long seq,String userID,String userName,String title, String content,Date regDate,int hit) {
        this(userID,title,content);
        this.seq = seq;
        this.regDate = regDate;
        this.hit = hit;
        this.userName = userName;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrNo() {
        return prNo;
    }

    public void setPrNo(int prNo) {
        this.prNo = prNo;
    }

    public int getReDepth() {
        return reDepth;
    }

    public void setReDepth(int reDepth) {
        this.reDepth = reDepth;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    @Override
    public String toString() {
        return "Board{" +
                "seq=" + seq +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", prNo=" + prNo +
                ", reDepth=" + reDepth +
                ", regDate=" + regDate +
                ", hit=" + hit +
                ", delYn='" + delYn + '\'' +
                '}';
    }
}
