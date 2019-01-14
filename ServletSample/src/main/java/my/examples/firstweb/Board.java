package my.examples.firstweb;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Board {
    // 필드
    private String number;
    private Long id;
    private String name;
    private String password;
    private String title;
    private String content;
    private LocalDate regdate;

    // 자기 자신의 생성자를 호출하는 방법
    // LocaDateTime 에 대하여 공부.
    public Board(){
        regdate = LocalDate.now(); // 현재 시간을 저장.
    }

    public Board(String name, String title, String content, String number) {
        this();
        this.number = number;
        this.name = name;
        this.title = title;
        this.content = content;
        this.number = number;
    }

    public Board(String name, String password, String title, String content, String number) {
        this(name, title, content, number);
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // getter , setter 메소드
    // id 프로퍼티
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDate regdate) {
        this.regdate = regdate;
    }
}
