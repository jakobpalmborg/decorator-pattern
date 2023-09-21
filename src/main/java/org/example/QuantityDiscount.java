package org.example;

public class QuantityDiscount extends BaseDiscount{
    @Override
    protected boolean isApplicable(Product product) {
        return false;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 0;
    }
}
