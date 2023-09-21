package org.example;

public interface Discount {
    public int apply(Product product);
    public String getDescription(Product product);
}
