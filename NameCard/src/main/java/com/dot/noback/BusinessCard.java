package com.dot.noback;

public class BusinessCard {
    private int id;
    private String name;
    private String phone;
    private String corporatioName;

    public BusinessCard() {
    }

    public BusinessCard(String name, String phone, String corporatioNname) {
        this.name = name;
        this.phone = phone;
        this.corporatioName = corporatioNname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCorporatioName() {
        return corporatioName;
    }

    public void setCorporatioNname(String corporatioNname) {
        this.corporatioName = corporatioNname;
    }



    @Override
    public String toString() {
        return "BusinessCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", corporatioNname='" + corporatioName + '\'' +
                '}';
    }
}