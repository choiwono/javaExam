package com.dot.noback;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BusniessCardUI {

    BusinessCardDaoImpl businessCardDaoImpl = new BusinessCardDaoImpl();
    Scanner scanner = new Scanner(System.in);

    public void InputNameCard() {

        System.out.println("=======명함관리 시스템=======");
        System.out.println("1. 명함 입력");
        System.out.println("2. 명함 수정");
        System.out.println("3. 명함 삭제");
        System.out.println("4. 명함 검색");
        System.out.println("5. 종료");
        String menuSelect = scanner.next();

        switch (menuSelect) {
            case "1" : businessCardAdd();
            case "2" : businessCardModify();
            case "3" : businessRemove();
            case "4" : busniessSearch();
            case "5" : busniessOut();
        }
        scanner.close();
    }

    public void businessCardAdd() {

        businessCardDaoImpl.load("./busniessCard.json");
        BusinessCardData businessCardData = new BusinessCardData();
        int Max = businessCardData.getMaxNum();

        System.out.println("이름을 입력해주세요.");
        String name = scanner.nextLine();
        System.out.println("회사명을 입력해주세요.");
        String company = scanner.nextLine();
        System.out.println("전화번호를 입력해주세요.");
        String phone = scanner.nextLine();

        BusinessCard businessCard = new BusinessCard(name,phone,company);
        businessCard.setId(Max);
        businessCardDaoImpl.insert(businessCard);
        businessCardDaoImpl.save("./busniessCard.json");
        continueMenu("add");
        scanner.close();
    }

    public void businessCardModify() {

        System.out.println("ID값을 입력해주세요.");
        String id = scanner.nextLine();
        System.out.println("수정할 내용을 골라주세요.");
        System.out.println("1. 이름, 2. 전화번호, 3.회사이름");
        String option = scanner.nextLine();
        System.out.println("수정할 내용을 입력해주세요.");
        String update = scanner.nextLine();
        boolean flag = businessCardDaoImpl.update(id,option,update);
        if(flag == true) {
            System.out.println("ID:"+id+" 수정에 성공하셨습니다.");
            continueMenu("modify");
        } else {
            System.out.println("수정에 실패하셨습니다. 다시 시도해주십시오.");
            continueMenu("modify");
        }
        scanner.close();
    }

    public void businessRemove() {

        System.out.println("ID값을 입력해주세요.");
        String id = scanner.nextLine();
        boolean flag = businessCardDaoImpl.remove(id);

        if(flag == true) {
            System.out.println("ID:"+id+" 삭제에 성공하셨습니다.");
            continueMenu("remove");
        } else {
            System.out.println("삭제에 실패하셨습니다. 일치하는 ID값이 없습니다.");
            continueMenu("remove");
        }
        scanner.close();
    }


    public void continueMenu(String option) {
        Scanner scanner = new Scanner(System.in);
        String str = null;

        switch (option) {
            case "add" : str = "입력"; break;
            case "modify" : str = "수정"; break;
            case "remove" : str = "삭제"; break;
        }
        System.out.println("추가적으로 "+str+"하시겠습니까? (Y/N)");
        String result = scanner.nextLine();

        if(result.equals("Y")) {
            switch(option) {
                case "add" : businessCardAdd(); break;
                case "modify" : businessCardModify(); break;
                case "remove" : businessRemove(); break;
            }
        } else {
            businessCardDaoImpl.save("./busniessCard.json");
            InputNameCard();
        }
    }

    public void busniessSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======검색 옵션을 선택해주세요======");
        System.out.println("0. ID");
        System.out.println("1. 이름");
        System.out.println("2. 전화번호");
        System.out.println("3. 회사이름");
        System.out.println("4. 전체리스트");
        String result = scanner.nextLine();

        switch (result) {
            case "0" : System.out.println("아이디값을 정확히 입력해주세요."); break;
            case "1" : System.out.println("이름값을 2글자이상 입력해주세요."); break;
            case "2" : System.out.println("전화번호를 2글자이상 입력해주세요."); break;
            case "3" : System.out.println("회사이름을 2글자이상 입력해주세요."); break;
            case "4" : System.out.println("전체 리스트를 출력합니다."); break;
        }

        String value = scanner.nextLine();
        List<BusinessCard> list = businessCardDaoImpl.find(result,value);

        Iterator<BusinessCard> itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        int num = list.size();

        if(num > 0) {
            System.out.println("====검색값을 수정 삭제하시겠습니까?====");
            System.out.println("1. 수정");
            System.out.println("2. 삭제");
            System.out.println("3. 메인메뉴로 돌아가기");
            System.out.println("4. 시스템 종료");
            String option = scanner.nextLine();

            switch(option) {
                case "1" : businessCardModify(); break;
                case "2" : businessRemove(); break;
                case "3" : InputNameCard(); break;
                case "4" : busniessOut(); break;
            }
        } else {
            System.out.println("검색값이 없습니다.");
        }
    }

    public void busniessOut() {
        System.out.println("시스템을 종료합니다.");
        System.exit(0);
    }
}
