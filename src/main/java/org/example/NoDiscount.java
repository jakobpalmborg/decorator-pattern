package org.example;

public class NoDiscount implements Discount {

    @Override
    public double apply(Product product, ShoppingCart shoppingCart) {
        return 0;
    }

    @Override
    public String getDescription(Product product) {
        return "";
    }
}
