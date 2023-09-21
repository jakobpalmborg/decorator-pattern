package org.example;

public class MilkDiscount extends BaseDiscount{
    @Override
    protected boolean isApplicable(Product product) {
        return false;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 0;
    }
}
