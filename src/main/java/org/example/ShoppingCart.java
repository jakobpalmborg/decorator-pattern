package org.example;

public class ShoppingCart {
    private int numberOfItems;
    private boolean isFriday;

    public ShoppingCart(int numberOfItems, boolean isFriday) {
        this.numberOfItems = numberOfItems;
        this.isFriday = isFriday;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public boolean isFriday() {
        return isFriday;
    }
}
