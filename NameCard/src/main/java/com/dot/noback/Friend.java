package com.dot.noback;

public class Friend {
    private String name;
    private String phone;

    // 불변클래스 : 생성할 때만 값이 들어가고, 그다음부터 값을 바꿀수없다.
    // 가지고 있는 어떤 메소드를 사용해도 필드값이 변하지 않는다.
    public Friend(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{이름:"+name+"}"+"{전화번호:"+phone+"}";
    }
}
