package com.dot.noback;

import java.util.ArrayList;
import java.util.List;

public class NamecardData {
    private int MaxNum;
    private List<NameCard> NamecardDataList = new ArrayList<NameCard>();

    public int getMaxNum() {
        return MaxNum;
    }

    public List<NameCard> getNamecardDataList() {
        return NamecardDataList;
    }

    public void setMaxNum(int maxNum) {
        MaxNum = maxNum;
    }

    public void setNamecardDataList(List<NameCard> namecardDataList) {
        NamecardDataList = namecardDataList;
    }

    @Override
    public String toString() {
        return "NameCardData{" +
                "MaxNum=" + MaxNum +
                ", NamecardDataList=" + NamecardDataList +
                '}';
    }
}
