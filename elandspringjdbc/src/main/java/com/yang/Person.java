package com.yang;

public class Person {
    private String city;
    private  String pName;
    private  Car car;
    private  String Info;

    public Person() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "city='" + city + '\'' +
                ", pName='" + pName + '\'' +
                ", car=" + car +
                ", Info='" + Info + '\'' +
                '}';
    }
}
