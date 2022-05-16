package com.qizhou.midtermpracticeexamwarm.entities;

public class ShoppingCar {
    private Item item;
    private Integer quantity;
    private Boolean added = false;

    public ShoppingCar(Item item) {
        this.item = item;
    }

    public ShoppingCar() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getAdded() {
        return added;
    }

    public void setAdded(Boolean added) {
        this.added = added;
    }
}
