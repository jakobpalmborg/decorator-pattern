package org.example;

import java.math.BigDecimal;

public interface Discount {
    public double apply(Product product);
    public String getDescription(Product product);
}
