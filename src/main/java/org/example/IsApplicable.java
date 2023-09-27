package org.example;
@FunctionalInterface
public interface IsApplicable {
    boolean isApplicable(Product product, ShoppingCart shoppingCart);
}
