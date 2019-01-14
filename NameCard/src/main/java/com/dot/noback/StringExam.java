package com.dot.noback;

public class StringExam {
    public static void main(String[] args) {
        // String은 불변 클래스 : 자기자신의 값이 바뀌지는 않는다.
        // == 참조한 값이 같은지 비교한다.
        // str3 -> 상수풀이라고 한다.
        String str = new String("Hello");
        String str2 = new String("Hello");
        String str3 = "Hello";
        String str4 = "Hello";
        String substring = str.substring(2);
        System.out.println(substring);
        System.out.println(str);

        if(str.equals(str2)) {
            System.out.println("str equals str2");
        }

        if(str == str2) {
            System.out.println("str == str2");
        }

        if(str.equals(str3)) {
            System.out.println("str equals:str3");
        }

        if(str == str3) {
            System.out.println("str == str3");
        }

        if(str3 == str4) {
            System.out.println("str == str4");
        }
    }
}
