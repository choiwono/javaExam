package my.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class IOExam02 {
    public static void main(String[] args){

        File file = new File("C:\\Users\\최원오\\Desktop");
        if(file.exists()) {
            if(file.isFile()) {
                printFile("",file);
            } else {
                printDir("",file);
            }
        } else {
            System.out.println("파일 혹은 폴더가 존재하지 않습니다.");
        }
    }

    public static void printFile(String space, File file) {
        System.out.println(space + file.getName() + file.length() + file.getParent());

    }

    public static void printDir(String space, File file) {
        System.out.println(space + file.getName() + "[DIR]");
        space = space + "  ";
        File[] files = file.listFiles();
        for(File f : files) {
            if(f.isFile()) {
                printFile(space,f);
            } else {
                printDir(space,f);
            }
        }
    }
}
