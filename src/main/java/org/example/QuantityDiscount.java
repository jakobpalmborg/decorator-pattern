package org.example;

public class QuantityDiscount extends BaseDiscount{


    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product, ShoppingCart shoppingCart) {
        return shoppingCart.getNumberOfItems() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product, ShoppingCart shoppingCart) {
        if (isApplicable(product, shoppingCart)) return 10.0;
        return 0;
    }

    @Override
    public double apply(Product product, ShoppingCart shoppingCart) {
        return calculateDiscount(product, shoppingCart) + nextDiscount.apply(product, shoppingCart);
    }

    @Override
    public String getDescription(Product product, ShoppingCart shoppingCart) {
        if(isApplicable(product, shoppingCart)) return nextDiscount.getDescription(product, shoppingCart) + "Quantity discount, ";
        else return nextDiscount.getDescription(product, shoppingCart);
    }
}
