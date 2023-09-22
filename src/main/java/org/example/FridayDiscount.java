package org.example;

public class FridayDiscount extends BaseDiscount{


    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return true;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 0;
    }

    @Override
    public double apply(Product product) {
        if (nextDiscount == null) {
            return calculateDiscount(product);
        } else {
            return calculateDiscount(product) + nextDiscount.apply(product);
        }
    }

    @Override
    public String getDescription(Product product) {
        return "Friday discount";
    }
}
