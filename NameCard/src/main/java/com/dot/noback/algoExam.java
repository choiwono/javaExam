    package com.dot.noback;

    public class algoExam {
        public static void main(String[] args) {

            int[] arr = new int[100];

            arr[1] = 1; // 1,2번째의 초기값은 1로 고정
            arr[2] = 1;

            for(int i=3; i<100; i++) { // i는 무조건 3부터 시작한다. 그전값은 -을 할수가없다.
                arr[i] = arr[i-1] + arr[i-2];
            }

            for(int i=1; i<100; i++) {
                System.out.println(arr[i]+" ");
            }
        }
    }
