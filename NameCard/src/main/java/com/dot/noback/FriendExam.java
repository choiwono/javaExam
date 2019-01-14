package com.dot.noback;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class FriendExam {
    FriendManager friendManager;

    @Before
    public void init() {
        friendManager = new FriendManager();
        Friend f1 = new Friend("choi","01062923620");
        friendManager.add(f1);

        Friend f2 = new Friend("wono","01025433620");
        friendManager.add(f2);

        Friend f3 = new Friend("ooo","01082824444");
        friendManager.add(f3);
    }

    @Test
    public void add() throws Exception {
        int size = friendManager.getNumber();
        Friend f4 = new Friend("O2O","01011114444");
        friendManager.add(f4);

        int size2 = friendManager.getNumber();
        if(size2 == (size+1)) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }
    }

    @Test
    public void find() throws Exception{

    }
}
