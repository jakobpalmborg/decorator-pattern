package org.example;

public interface Discount {
    double apply(Product product, ShoppingCart shoppingCart);
    String getDescription(Product product, ShoppingCart shoppingCart);
}
