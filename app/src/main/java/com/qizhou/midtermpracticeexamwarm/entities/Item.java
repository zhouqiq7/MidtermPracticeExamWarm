package com.qizhou.midtermpracticeexamwarm.entities;

public class Item {
    private String name;
    private Double unitPrice;

    public Item(String name, Double price) {
        this.name = name;
        this.unitPrice = price;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
