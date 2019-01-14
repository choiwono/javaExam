package com.dot.noback;

public class Data {
    private int value;

    public Data(int value) {
        this.value = value;
    }

    public Data(Data d) { // 카피생성자, 기존의 있는 데이터값을 카피한다!!
        this.value = d.getValue();
    }

    public int getValue() {
        return value;
    }

    public Data cloneData() {
        Data data = new Data(this.value);
        return data;
    }
}
