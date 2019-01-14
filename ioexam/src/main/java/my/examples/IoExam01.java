package my.examples;

import java.io.File;

public class IoExam01 {
    public static void main(String[] args) {
        // 폴더를 만들어주시고ㅡ 그안에 몇가지 폴더를 만든다.
        // 1. 위의 폴더가 있는지 없는지 검사한다. 있으면 있다. 없으면 없다고 출력
        // 2. 해당 경로가 파일인지, 폴더인지 검사한다. 파일이면 파일, 폴더면 폴더로 출력
        //    출력
        // 3. 해당 경로에 어떤 파일과 폴더들이 있는지 정보를 출력한다.
        // 4. IOExam02를 만든다. path를 지정하면 폴더일 경우, 해당 폴더아래의 모든 파일과 폴더정보를
        //    출력한다.
        // 파일과 관련된 파일 패키지가 모두 포함돼 있다.
        File file = new File("c:\\Users\\최원오\\Desktop\\ExamTest");

        boolean isExists = file.exists();

        if(!isExists) {
            System.out.println("There is nothing.");
        }

        // 2. check if the object is directory or not.
        if(file.isDirectory()) {
            File[] fileList = file.listFiles();
            for(File tFile : fileList) {
                if(tFile.isDirectory()) {
                    System.out.println(tFile.getName());
                }
            }
        } else {
            System.out.println("-_-");
        }

    }

    public static class IOExam02 {

    }
}
