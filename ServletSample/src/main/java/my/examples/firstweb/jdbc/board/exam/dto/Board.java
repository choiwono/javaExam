package my.examples.firstweb.jdbc.board.exam.dto;

import java.sql.Date;

public class Board {
    private int seq;
    private String userID;
    private String userName;
    private String title;
    private String content;
    private String password;
    private int prNo;
    private int reDepth;
    private Date regDate;
    private int hit;
    private String delYn;

    public Board() {
        this.seq = seq;
        this.prNo = prNo;
        this.reDepth = reDepth;
        this.regDate = regDate;
        this.hit = hit;
        this.delYn = delYn;
    }

    public Board(String userID, String userName, String title, String content) {
        this();
        this.userID = userID;
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

    public Board(String userID,String userName,String title, String content,String password) {
        this(userID,userName,title,content);
        this.password = password;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
