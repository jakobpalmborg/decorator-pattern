package org.example;
@FunctionalInterface
public interface CalculateDiscount {
    double calculateDiscount(Product product, ShoppingCart shoppingCart);
}
