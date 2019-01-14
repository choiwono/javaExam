package com.dot.noback;

public class algo3Exam {
    public static void main(String[] args) {

        int inputNum = 19;
        int bin[] = new int[100];

        /*

         * 19 / 2 ---- 9 ... 1
         * 9  / 2 ---- 4 ... 1
         * 4  / 2 ---- 2 ... 0
         * 2  / 2 ---- 1 ... 0
         * 1  / 2 ---- 0 ... 1
           10011 => 19
        */

        int i = 0;
        int mok = inputNum;

        while(mok > 0) { // mok이 0일때 끝난다.
            bin[i] = mok % 2; // bin[0] = 1 (19 % 2), bin[1] = 1 (9%2)
            mok /= 2; // 19/2 = 9, 9/2 = 4
            i++; // 배열이 0일때, 1일때 계산
        }
        i--; // i++ 후위 연산자기 때문에 값이 1이 더 증가됐기 때문에 빼준다.

        for(; i>=0; i--) {
            System.out.println(bin[i]); // 배열 뒷자리부터 출력해야한다.
        }
    }
}

