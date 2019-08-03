package com.yang;

public class Car {
    private  String brand;
    private  int price;
    //周长
    private  double tyrperimeter;

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTyrperimeter() {
        return tyrperimeter;
    }

    public void setTyrperimeter(double tyrperimeter) {
        this.tyrperimeter = tyrperimeter;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyrperimeter=" + tyrperimeter +
                '}';
    }
}
