package com.dot.noback;

import java.util.Scanner;

public class algo2Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNum = new int[10];
        for(int i=0; i<10; i++) {
            inputNum[i] = scanner.nextInt();
            System.out.println(inputNum[i]);
        }

        int[] max = new int[10];

        for(int i=0; i<10; i++) {
            max[inputNum[i]]++;
        }

        int modeNum = 0;
        int modeCnt = 0;

        for(int i=0; i<10; i++) {
            if(modeCnt < max[i]) {
                modeCnt = max[i];
                modeNum = i;
            }
        }
    }
}
