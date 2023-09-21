package org.example;

public abstract class BaseDiscount {
    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);

    Discount nextDiscount;
}
