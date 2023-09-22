package org.example;

public class QuantityDiscount extends BaseDiscount{


    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product, ShoppingCart shoppingCart) {
        return false;
    }

    @Override
    protected double calculateDiscount(Product product, ShoppingCart shoppingCart) {
        return 0;
    }

    @Override
    public double apply(Product product, ShoppingCart shoppingCart) {
        if (nextDiscount == null) {
            return calculateDiscount(product, shoppingCart);
        } else {
        return calculateDiscount(product, shoppingCart) + nextDiscount.apply(product, shoppingCart);
        }
    }

    @Override
    public String getDescription(Product product) {
        return "Quantity discount";
    }
}
