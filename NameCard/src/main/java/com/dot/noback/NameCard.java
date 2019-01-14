package com.dot.noback;

public class NameCard {
    private int id;
    private String name;
    private String phone;
    private String company;

    public NameCard() {

    }

    public NameCard(String name, String phone, String company, int id) {
        this.name = name;
        this.phone = phone;
        this.company = company;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "NameCardData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
