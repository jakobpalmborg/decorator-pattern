package org.example;

import java.math.BigDecimal;

public interface Discount {
    public double apply(Product product, ShoppingCart shoppingCart);
    public String getDescription(Product product, ShoppingCart shoppingCart);
}
