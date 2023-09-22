package org.example;

public abstract class BaseDiscount implements Discount {

    protected final Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product, ShoppingCart shoppingCart);
    protected abstract double calculateDiscount(Product product, ShoppingCart shoppingCart);


}
