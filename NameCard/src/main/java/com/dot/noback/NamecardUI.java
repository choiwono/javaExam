package com.dot.noback;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NamecardUI {
    NamecardData namecardData = new NamecardData();
    List<NameCard> nameCardList = new ArrayList<NameCard>();

    public void InputNameCard() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("메뉴를 선택해주세요.");
        System.out.println("1.명함입력, 2.명함검색, 3.명함수정, 4.명함삭제, 5.전체조회, 6.종료");
        String menuSelect = scanner.next();

        switch (menuSelect) {
            case "1" : nameAdd(); break;
            case "2" : nameSearchUI(); break;
            case "6" : scanner.close(); break;
            /*
            case 3 : nameModify(); break;
            case 4 : nameRemove(); break;
            */
        }
    }

    public void nameAdd() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("이름을 입력해주세요.");
        String name = scanner.nextLine();
        System.out.println("회사이름을 입력해주세요.");
        String companyName = scanner.nextLine();
        System.out.println("-을 제외하고 휴대포번호을 입력해주세요");
        String phoneNumber = scanner.nextLine();

        int maxnum = namecardData.getMaxNum()+1;
        namecardData.setMaxNum(maxnum);

        NameCard nameCard = new NameCard(name,companyName,phoneNumber,maxnum);
        nameCardList.add(nameCard);

        Iterator<NameCard> itr = nameCardList.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        continueAdd(nameCardList);
    }

    public void continueAdd(List<NameCard> nameCardList) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("더 입력하시겠습니까? (Y/N)");
        String result = scanner.nextLine();

        if(result.equals("Y")) {
            nameAdd();
        } else {
            nameSave(nameCardList);
        }
    }

    public void nameSave(List<NameCard> nameCardList) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("./businesscard.json");

        System.out.println("저장하시겠습니까? (Y/N)");
        String result = scanner.nextLine();

        if(result.equals("Y")) {
            objectMapper.writeValueAsString(nameCardList);
            objectMapper.writeValue(file, this.nameCardList);
        } else {
            InputNameCard();
        }
    }

    public void nameSearchUI() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색 옵션을 선택해주세요.");
        System.out.println("1.이름, 2.회사, 3.휴대폰번호");
        String result = scanner.nextLine();
        switch (result) {
            case "1" : nameSearch(); break;
            case "2" : companySearch(); break;
            case "3" : phoneSearch(); break;
        }
    }

    /*public void readNameCardData() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("./businesscard.json");
        NamecardData nameCardData = objectMapper.readValue(file, nameCardData.class);

        System.out.println(businessCardData);
    }*/

    public void nameSearch() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 1글자 이상 입력해주세요.");
        String result = scanner.nextLine();

    }

    public void companySearch() {

    }

    public void phoneSearch() {

    }
}
