package my.examples.jdbcboard.dto;

import java.util.Date;

// id | title  | content  | name | regdate             | read_count
public class Board {
    private Long id;
    private String title;
    private String content;
    private String name;
    private Date regdate;
    private String email;
    private int readCount;

    public Board(){
        this.regdate = new Date();
        this.readCount = 0;
    }

    public Board(String title, String content, String name, Long id) {
        this();
        this.title = title;
        this.content = content;
        this.name = name;
        this.id = id;
    }

    public Board(Long id, String title, String content, String name, Date regdate, int readCount,String email) {
        this(title, content, name, id);
        this.email = email;
        this.id = id;
        this.regdate = regdate;
        this.readCount = readCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }


    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", regdate=" + regdate +
                ", readCount=" + readCount +
                '}';
    }
}
