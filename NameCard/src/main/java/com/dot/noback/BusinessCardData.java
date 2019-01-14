package com.dot.noback;

import java.util.ArrayList;
import java.util.List;

public class BusinessCardData {
    private int maxNum;
    private List<BusinessCard> businessCardList;

    // 필드를 초기화한다.
    public BusinessCardData(){
        this.maxNum = 1;
        businessCardList = new ArrayList<>();
    }

    public void add(BusinessCard bc) {
        businessCardList.add(bc);
    }

    public int getMaxNum() {
        return maxNum++;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public List<BusinessCard> getBusinessCardList() {
        return businessCardList;
    }

    public void setBusinessCardList(List<BusinessCard> businessCardList) {
        this.businessCardList = businessCardList;
    }

    public int getNumberList() {
        return businessCardList.size();
    }

    @Override
    public String toString() {
        return "BusinessCardData{" +
                "maxNum=" + maxNum +
                ", businessCardList=" + businessCardList +
                '}';
    }
}
