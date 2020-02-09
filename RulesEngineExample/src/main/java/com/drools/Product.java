package com.drools;

public class Product {
    private String type;
    private int discount;

    public Product(String type, int discount) {
        this.type = type;
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", discount=" + discount +
                '}';
    }
}
