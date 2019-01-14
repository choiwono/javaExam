package com.dot.noback;

import java.util.ArrayList;
import java.util.List;

public class FriendManager {
    private List<Friend> friendList;
    public FriendManager() {
        friendList = new ArrayList<>();
    }

    public void add(Friend fd) {
        friendList.add(fd);
    }

    public List<Friend> find(String name) {
        List<Friend> list = new ArrayList<>();
        String findName = null;
        for(int i=0; i<friendList.size(); i++) {
            findName = friendList.get(i).getName();
            if(findName.contains(name)) {
                list.add(friendList.get(i));
            }
        }
        return list;
    }

    public boolean remove(String phone) {
        boolean flag = false;
        String result = null;
        try {
            for(int i=0; i<friendList.size(); i++) {
                result = friendList.get(i).getPhone();
                if(result.equals(phone)) {
                    friendList.remove(i);
                }
            }
            flag = true;
        } catch(Exception em) {
            flag = false;
            System.out.println(em);
        }
        return flag;
    }

    public int getNumber() {
       int number = friendList.size();
       return number;
    }

    public List<Friend> getList() {
        return friendList;
    }
    // 친구추가
    // 이름에 해당하는 친구정보들을 반환
    // 전화번호에 해당하는 친구를 삭제
}
